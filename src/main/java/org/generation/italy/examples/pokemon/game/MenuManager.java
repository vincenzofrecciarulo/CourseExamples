package org.generation.italy.examples.pokemon.game;

import org.generation.italy.examples.pokemon.model.Player;
import org.generation.italy.examples.pokemon.model.Pokemon;
import org.generation.italy.examples.pokemon.util.SafeConsole;

import java.util.Map;

public class MenuManager {

    public static void printTitle() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    POKÉMON RPG — Generation I        ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static int mainMenu() {
        System.out.println("\n══════ MAIN MENU ══════");
        System.out.println("[1] New Game");
        System.out.println("[2] Pokédex");
        System.out.println("[3] Exit");
        System.out.print("Choice > ");
        return SafeConsole.readInt(1, 3);
    }

    public static int overworldMenu(Area area, Player player) {
        if (player == null) throw new IllegalStateException("overworldMenu: player non può essere null");
        if (player.getActivePokemon() == null) throw new IllegalStateException("overworldMenu: il giocatore non ha un Pokémon attivo");

        System.out.println("\n══════ " + area.getDisplayName().toUpperCase() + " ══════");
        System.out.printf("  Trainer: %-12s  Money: $%d%n", player.getName(), player.getMoney());
        System.out.println("  " + player.getActivePokemon());
        System.out.println();

        int opt = 1;
        System.out.println("[" + opt++ + "] Move forward  → " + area.next().getDisplayName());
        if (area.ordinal() > 0)
            System.out.println("[" + opt++ + "] Move back     ← " + area.prev().getDisplayName());
        if (area.hasWildEncounters())
            System.out.println("[" + opt++ + "] Explore (encounter)");
        if (area.hasPokemonCenter())
            System.out.println("[" + opt++ + "] Pokémon Center");
        System.out.println("[" + opt++ + "] Inventory");
        System.out.println("[" + opt++ + "] Pokédex");
        System.out.println("[" + opt   + "] Save & Exit");
        System.out.print("Choice > ");
        return SafeConsole.readInt(1, opt);
    }

    public static int starterMenu() {
        System.out.println("\nChoose your starter Pokémon:");
        System.out.println("[1] Bulbasaur  (Grass / Poison)");
        System.out.println("[2] Charmander (Fire)");
        System.out.println("[3] Squirtle   (Water)");
        System.out.print("Choice > ");
        return SafeConsole.readInt(1, 3);
    }

    public static int pokemonCenterMenu() {
        System.out.println("\n══ Pokémon Center ══");
        System.out.println("[1] Heal Pokémon (FREE)");
        System.out.println("[2] Shop");
        System.out.println("[3] Leave");
        System.out.print("Choice > ");
        return SafeConsole.readInt(1, 3);
    }

    public static int shopMenu() {
        System.out.println("\n── Shop ──");
        System.out.println("[1] Potion       300 coins");
        System.out.println("[2] Super Potion 700 coins");
        System.out.println("[3] Poké Ball    200 coins");
        System.out.println("[0] Leave");
        System.out.print("Choice > ");
        return SafeConsole.readInt(0, 3);
    }

    public static int pokedexSearchMenu() {
        System.out.println("\n──── Pokédex Search ────");
        System.out.println("[1] Search by number");
        System.out.println("[2] Search by name");
        System.out.println("[3] List all");
        System.out.println("[0] Back");
        System.out.print("Choice > ");
        return SafeConsole.readInt(0, 3);
    }

    public static void showInventory(Player player) {
        if (player == null) { System.out.println("  (nessun giocatore attivo)"); return; }
        System.out.println("\n── Bag ──");
        Map<String, Integer> inv = player.getInventory();
        if (inv.isEmpty()) { System.out.println("  (empty)"); }
        else inv.forEach((name, qty) -> System.out.printf("  %-16s x%d%n", name, qty));
        System.out.println("  Coins: $" + player.getMoney());
    }

    public static void showPokemonStatus(Pokemon p) {
        if (p == null) { System.out.println("  (nessun Pokémon)"); return; }
        System.out.println("\n── " + p.getName() + " Status ──");
        System.out.println(p);
        System.out.println("  Moves:");
        if (p.getMoves().isEmpty()) {
            System.out.println("    (nessuna mossa disponibile)");
        } else {
            p.getMoves().forEach(m -> System.out.println("    " + m));
        }
    }

    private MenuManager() {}
}