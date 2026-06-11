package org.generation.italy.examples.pokemon.game;

import org.generation.italy.examples.pokemon.model.*;
import org.generation.italy.examples.pokemon.service.*;
import org.generation.italy.examples.pokemon.util.*;

public class GameLoop {

    private Player player;
    private Area currentArea;
    private final Pokedex pokedex;
    private boolean running;

    public GameLoop() {
        pokedex = buildPokedex();
    }

    // ─── Entry point ─────────────────────────────────────────────────────────

    public void start() {
        running = true;
        MenuManager.printTitle();
        try {
            while (running) {
                int choice = MenuManager.mainMenu();
                switch (choice) {
                    case 1 -> startNewGame();
                    case 2 -> openPokedex();
                    case 3 -> { System.out.println("Goodbye!"); running = false; }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (IllegalStateException e) {
            // Stato di gioco corrotto (es. Pokémon null, area non valida)
            System.err.println("\n[ERRORE DI STATO] " + e.getMessage());
            System.err.println("Il gioco non può continuare in questo stato. Torna al menù principale.");
            running = false;
        } catch (Exception e) {
            // Qualsiasi altra eccezione non prevista
            System.err.println("\n[ERRORE CRITICO] " + e.getClass().getSimpleName() + ": " + e.getMessage());
            System.err.println("Il gioco si è interrotto inaspettatamente.");
            e.printStackTrace();
            running = false;
        }
    }

    // ─── New Game ────────────────────────────────────────────────────────────

    private void startNewGame() {
        System.out.print("\nEnter your name: ");
        String name = SafeConsole.readString();
        player = new Player(name);
        currentArea = Area.PALLET_TOWN;

        System.out.println("\nWelcome, " + name + "! Your journey begins in Pallet Town.");
        Pokemon starter = chooseStarter();
        player.setActivePokemon(starter);
        System.out.println("\nYou received " + starter.getName() + "! Good luck on your adventure!");

        overworldLoop();
    }

    private Pokemon chooseStarter() {
        while (true) {
            int choice = MenuManager.starterMenu();
            PokedexEntry entry = switch (choice) {
                case 1 -> PokedexData.BULBASAUR;
                case 2 -> PokedexData.CHARMANDER;
                case 3 -> PokedexData.SQUIRTLE;
                default -> null;
            };
            if (entry != null) return new Pokemon(entry, 5);
            System.out.println("Invalid choice, try again.");
        }
    }

    // ─── Overworld ───────────────────────────────────────────────────────────

    private void overworldLoop() {
        boolean inGame = true;
        while (inGame && running) {
            // Re-build the menu choice set dynamically
            int choice = MenuManager.overworldMenu(currentArea, player);
            inGame = handleOverworldChoice(choice);
        }
    }

    /**
     * Maps the numeric choice from the dynamic overworld menu to an action.
     * Returns false when the player chooses to save & exit.
     */
    private boolean handleOverworldChoice(int choice) {
        int opt = 1;
        // [opt++] Move forward
        if (choice == opt++) {
            Area next = currentArea.next();
            if (next == currentArea) { System.out.println("There's nowhere further to go!"); }
            else { currentArea = next; System.out.println("You moved to " + currentArea.getDisplayName() + "."); }
            return true;
        }
        // [opt++] Move back (only shown when not at start)
        if (currentArea.ordinal() > 0) {
            if (choice == opt++) {
                currentArea = currentArea.prev();
                System.out.println("You moved back to " + currentArea.getDisplayName() + ".");
                return true;
            }
        }
        // [opt++] Explore / Encounter (if area has wild encounters)
        if (currentArea.hasWildEncounters()) {
            if (choice == opt++) {
                handleExplore();
                return true;
            }
        }
        // [opt++] Pokémon Center (if area has one)
        if (currentArea.hasPokemonCenter()) {
            if (choice == opt++) {
                handlePokemonCenter();
                return true;
            }
        }
        // [opt++] Inventory
        if (choice == opt++) {
            MenuManager.showInventory(player);
            return true;
        }
        // [opt++] Pokédex
        if (choice == opt++) {
            openPokedex();
            return true;
        }
        // [opt] Save & Exit
        if (choice == opt) {
            System.out.println("See you next time, " + player.getName() + "!");
            return false;
        }
        System.out.println("Invalid choice.");
        return true;
    }

    // ─── Wild encounter ──────────────────────────────────────────────────────

    private void handleExplore() {
        Pokemon hero = player.getActivePokemon();
        if (hero == null || !hero.isAlive()) {
            System.out.println("Il tuo Pokémon è esausto! Visita un Pokémon Center prima di esplorare.");
            return;
        }
        if ((int) (Math.random() * 100) < 40) {
            System.out.println("\nYou venture into the area...");
            int dexNum = currentArea.pickEncounterDexNumber();
            PokedexEntry entry = pokedex.getByNumber(dexNum);
            if (entry == null) { System.out.println("Nothing appeared..."); return; }

            int[] range = currentArea.wildLevelRange();
            int wildLevel = range[0] + (int) (Math.random() * (range[1] - range[0] + 1));
            Pokemon wild = new Pokemon(entry, wildLevel);

            BattleResult result = BattleService.runBattle(player, wild);
            handleBattleResult(result, wild);
        } else {
            System.out.println("\nYou walked around but found nothing...");
        }
    }

    private void handleBattleResult(BattleResult result, Pokemon wild) {
        switch (result) {
            case VICTORY -> {
                System.out.println("\n" + player.getActivePokemon().getName() + " won!");
                grantXp(player.getActivePokemon(), wild);
                player.earnMoney((int) (Math.random() * 100) + 50);
                System.out.println("You found $" + ((int)(Math.random() * 100) + 50) + " on the ground.");
            }
            case CAUGHT -> {
                System.out.println("\n" + wild.getName() + " was added to your caught list!");
                wild.fullHeal();
                player.addCaughtPokemon(wild);
            }
            case DEFEAT -> {
                System.out.println("\nYou lost the battle! Heading to the nearest Pokémon Center...");
                player.getActivePokemon().fullHeal();
                System.out.println(player.getActivePokemon().getName() + " was fully restored.");
            }
            case FLED -> System.out.println("You escaped safely.");
        }
    }

    // ─── XP and leveling ─────────────────────────────────────────────────────

    private void grantXp(Pokemon pokemon, Pokemon defeated) {
        if (pokemon == null || defeated == null || defeated.getEntry() == null) return;
        int xpGain = XpCalculator.xpGain(defeated.getLevel(), defeated.getEntry().getBaseXpYield());
        pokemon.addXp(xpGain);
        System.out.printf("%n  %s gained %d XP!%n", pokemon.getName(), xpGain);

        while (pokemon.getXp() >= XpCalculator.xpForLevel(pokemon.getLevel() + 1)) {
            boolean canEvolve = pokemon.levelUp();
            System.out.printf("  %s grew to Lv.%d!%n", pokemon.getName(), pokemon.getLevel());
            printStatSummary(pokemon);

            if (canEvolve) triggerEvolution(pokemon);
        }

        int toNext = XpCalculator.xpToNextLevel(pokemon.getLevel(), pokemon.getXp());
        System.out.printf("  (Next level in %d XP)%n", toNext);
    }

    private void triggerEvolution(Pokemon pokemon) {
        if (pokemon == null || pokemon.getEntry() == null) return;
        PokedexEntry evoEntry = pokedex.getByNumber(pokemon.getEntry().getEvolutionNumber());
        if (evoEntry == null) {
            // Numero di evoluzione registrato ma non presente nel Pokédex di gioco
            System.out.println("  (dati di evoluzione mancanti nel Pokédex)");
            return;
        }
        String oldName = pokemon.getName();
        try {
            System.out.printf("%n  What?! %s is evolving!%n", oldName);
            pokemon.evolve(evoEntry);
            System.out.printf("  %s evolved into %s!%n", oldName, pokemon.getName());
        } catch (IllegalArgumentException e) {
            System.err.println("  [!] Evoluzione fallita: " + e.getMessage());
        }
    }

    private void printStatSummary(Pokemon p) {
        System.out.printf("    HP:%d  ATK:%d  DEF:%d  SpA:%d  SpD:%d  SPE:%d%n",
                p.getMaxHp(), p.getAttack(), p.getDefense(),
                p.getSpAttack(), p.getSpDefense(), p.getSpeed());
    }

    // ─── Pokémon Center ──────────────────────────────────────────────────────

    private void handlePokemonCenter() {
        boolean atCenter = true;
        while (atCenter) {
            int choice = MenuManager.pokemonCenterMenu();
            switch (choice) {
                case 1 -> {
                    player.getActivePokemon().fullHeal();
                    System.out.println("Your Pokémon has been fully restored. Have a nice trip!");
                }
                case 2 -> handleShop();
                case 3 -> atCenter = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void handleShop() {
        boolean shopping = true;
        while (shopping) {
            int choice = MenuManager.shopMenu();
            switch (choice) {
                case 1 -> buyItem("Potion", 300);
                case 2 -> buyItem("Super Potion", 700);
                case 3 -> buyItem("Poké Ball", 200);
                case 0 -> shopping = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void buyItem(String name, int price) {
        System.out.printf("Buy %s for $%d? [1] Yes  [2] No%n> ", name, price);
        int confirm = SafeConsole.readInt(1, 2);
        if (confirm != 1) return;
        if (player.spend(price)) {
            player.addItem(name, 1);
            System.out.println("Got " + name + "! (Remaining: $" + player.getMoney() + ")");
        } else {
            System.out.println("Not enough money!");
        }
    }

    // ─── Pokédex ─────────────────────────────────────────────────────────────

    private void openPokedex() {
        boolean open = true;
        while (open) {
            int choice = MenuManager.pokedexSearchMenu();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter dex number: ");
                    int num = SafeConsole.readInt(1, 999);
                    PokedexService.display(pokedex.getByNumber(num));
                }
                case 2 -> {
                    System.out.print("Enter name: ");
                    String name = SafeConsole.readString();
                    PokedexService.display(pokedex.getByName(name));
                }
                case 3 -> PokedexService.listAll(pokedex);
                case 0 -> open = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ─── Pokedex initialiser ─────────────────────────────────────────────────

    private static Pokedex buildPokedex() {
        Pokedex dex = new Pokedex();
        dex.register(PokedexData.BULBASAUR);
        dex.register(PokedexData.IVYSAUR);
        dex.register(PokedexData.VENUSAUR);
        dex.register(PokedexData.CHARMANDER);
        dex.register(PokedexData.CHARMELEON);
        dex.register(PokedexData.CHARIZARD);
        dex.register(PokedexData.SQUIRTLE);
        dex.register(PokedexData.WARTORTLE);
        dex.register(PokedexData.BLASTOISE);
        dex.register(PokedexData.CATERPIE);
        dex.register(PokedexData.BUTTERFREE);
        dex.register(PokedexData.PIDGEY);
        dex.register(PokedexData.PIDGEOTTO);
        dex.register(PokedexData.PIDGEOT);
        dex.register(PokedexData.RATTATA);
        dex.register(PokedexData.RATICATE);
        dex.register(PokedexData.PIKACHU);
        dex.register(PokedexData.RAICHU);
        dex.register(PokedexData.GEODUDE);
        dex.register(PokedexData.GRAVELER);
        dex.register(PokedexData.GASTLY);
        dex.register(PokedexData.HAUNTER);
        dex.register(PokedexData.GENGAR);
        dex.register(PokedexData.SNORLAX);
        dex.register(PokedexData.MEWTWO);
        return dex;
    }
}