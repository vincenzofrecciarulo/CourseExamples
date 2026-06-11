package org.generation.italy.examples.pokemon.service;

import org.generation.italy.examples.pokemon.model.*;
import org.generation.italy.examples.pokemon.util.DamageCalculator;
import org.generation.italy.examples.pokemon.util.SafeConsole;
import org.generation.italy.examples.pokemon.util.TypeChart;

import java.util.List;
import java.util.stream.Collectors;

public class BattleService {

    /**
     * Esegue una battaglia completa contro un Pokémon selvatico.
     *
     * @throws IllegalArgumentException se player o wild sono null
     */
    public static BattleResult runBattle(Player player, Pokemon wild) {
        if (player == null) throw new IllegalArgumentException("player non può essere null");
        if (wild == null)   throw new IllegalArgumentException("wild non può essere null");

        Pokemon hero = player.getActivePokemon();
        if (hero == null)   throw new IllegalStateException("Il giocatore non ha un Pokémon attivo");
        if (!hero.isAlive()) {
            System.out.println("Il tuo Pokémon è esausto! Visita un Pokémon Center prima di combattere.");
            return BattleResult.DEFEAT;
        }

        System.out.println("\n══════════════════════════════════════");
        System.out.println("  A wild " + wild.getName() + " appeared!");
        System.out.println("══════════════════════════════════════");

        while (hero.isAlive() && wild.isAlive()) {
            printStatus(hero, wild);
            int choice = showBattleMenu();

            switch (choice) {
                case 1 -> { // Fight
                    Move move = chooseMove(hero);
                    if (move == null) continue; // mossa non valida: re-mostra il menù
                    boolean wildFainted = executePlayerMove(hero, wild, move);
                    if (wildFainted || !wild.isAlive()) return BattleResult.VICTORY;
                }
                case 2 -> { // Item
                    boolean itemUsed = handleItemMenu(player, hero, wild);
                    if (!itemUsed) continue; // oggetto non usato: non far agire il nemico
                    if (!wild.isAlive()) return BattleResult.CAUGHT;
                }
                case 3 -> { // Run
                    if (tryRun(hero, wild)) {
                        System.out.println("Got away safely!");
                        return BattleResult.FLED;
                    }
                    System.out.println("Can't escape!");
                }
                default -> { continue; } // scelta fuori range: chiedi di nuovo
            }

            // Turno del nemico (solo se è ancora vivo)
            if (wild.isAlive() && hero.isAlive()) {
                executeEnemyMove(wild, hero);
            }

            // Danno di fine turno da status
            applyEndOfTurnStatus(hero);
            applyEndOfTurnStatus(wild);

            if (!hero.isAlive()) {
                System.out.println(hero.getName() + " fainted!");
                return BattleResult.DEFEAT;
            }
        }

        return hero.isAlive() ? BattleResult.VICTORY : BattleResult.DEFEAT;
    }

    // ─── Metodi privati ──────────────────────────────────────────────────────

    private static void printStatus(Pokemon hero, Pokemon wild) {
        System.out.println("\n──────────────────────────────────────");
        printHpBar(wild.getName() + " (Lv." + wild.getLevel() + ")",
                   wild.getCurrentHp(), wild.getMaxHp(), wild.getStatus());
        System.out.println();
        printHpBar(hero.getName() + " (Lv." + hero.getLevel() + ")",
                   hero.getCurrentHp(), hero.getMaxHp(), hero.getStatus());
        System.out.println("──────────────────────────────────────");
    }

    private static void printHpBar(String label, int current, int max, StatusEffect status) {
        if (max <= 0) max = 1; // evita divisione per zero nella barra
        int barLength = 20;
        int filled = (int) ((double) current / max * barLength);
        filled = Math.max(0, Math.min(barLength, filled)); // clamp [0, barLength]
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) bar.append(i < filled ? "█" : "░");
        bar.append("]");
        System.out.printf("  %-20s %s %d/%d [%s]%n", label, bar, current, max, status.getLabel());
    }

    private static int showBattleMenu() {
        System.out.println("\n  What will you do?");
        System.out.println("  [1] Fight   [2] Item   [3] Run");
        System.out.print("  > ");
        return SafeConsole.readInt(1, 3);
    }

    /**
     * Mostra l'elenco mosse e chiede la scelta al giocatore.
     * Restituisce null se la scelta è invalida (mossa senza PP o fuori indice):
     * il chiamante deve gestire null ripetendo il turno.
     */
    private static Move chooseMove(Pokemon pokemon) {
        List<Move> moves = pokemon.getMoves();

        if (moves == null || moves.isEmpty()) {
            System.out.println("  " + pokemon.getName() + " non ha mosse! (Struggle non implementato)");
            return null;
        }

        System.out.println("\n  Choose a move:");
        for (int i = 0; i < moves.size(); i++) {
            Move m = moves.get(i);
            String ppWarning = m.getCurrentPp() == 0 ? " [NO PP]" : "";
            System.out.printf("  [%d] %s%s%n", i + 1, m, ppWarning);
        }
        System.out.print("  > ");
        int idx = SafeConsole.readInt(1, moves.size()) - 1;

        Move chosen = moves.get(idx);
        if (!chosen.hasPp()) {
            System.out.println("  Questa mossa non ha più PP!");
            return null;
        }
        return chosen;
    }

    /** Restituisce true se il difensore è esausto. */
    private static boolean executePlayerMove(Pokemon attacker, Pokemon defender, Move move) {
        if (isImmobilized(attacker)) return false;
        move.usePp();
        System.out.printf("%n  %s used %s!%n", attacker.getName(), move.getName());
        return applyMove(attacker, defender, move);
    }

    private static void executeEnemyMove(Pokemon enemy, Pokemon target) {
        if (isImmobilized(enemy)) return;
        Move move = pickEnemyMove(enemy);
        if (move == null) {
            System.out.println("  " + enemy.getName() + " ha esaurito le PP di tutte le mosse!");
            return;
        }
        move.usePp();
        System.out.printf("%n  Wild %s used %s!%n", enemy.getName(), move.getName());
        applyMove(enemy, target, move);
    }

    /** Restituisce true se il difensore è esausto dopo il colpo. */
    private static boolean applyMove(Pokemon attacker, Pokemon defender, Move move) {
        if (defender == null) return false;

        // Controllo accuratezza
        if ((int) (Math.random() * 100) >= move.getAccuracy()) {
            System.out.println("  " + attacker.getName() + "'s attack missed!");
            return false;
        }

        if (move.getCategory() == MoveCategory.STATUS) {
            applyStatusMove(defender, move);
            return false;
        }

        int damage = DamageCalculator.calculate(attacker, defender, move);
        double effectiveness = TypeChart.getEffectiveness(move.getType(), defender.getTypes());
        String label = TypeChart.effectivenessLabel(effectiveness);
        if (!label.isEmpty()) System.out.println("  " + label);

        if (effectiveness == 0.0) {
            System.out.println("  " + defender.getName() + " è immune a " + move.getType() + "!");
            return false;
        }

        defender.takeDamage(damage);
        System.out.printf("  %s took %d damage!%n", defender.getName(), damage);

        // Possibilità di infliggere uno status
        StatusEffect toApply = move.getAppliesStatus();
        if (toApply != null && toApply != StatusEffect.NONE
                && (int) (Math.random() * 100) < move.getStatusChance()
                && defender.getStatus() == StatusEffect.NONE) {
            defender.setStatus(toApply);
            System.out.printf("  %s was inflicted with %s!%n", defender.getName(), toApply);
        }

        if (!defender.isAlive()) System.out.println("  " + defender.getName() + " fainted!");
        return !defender.isAlive();
    }

    private static void applyStatusMove(Pokemon target, Move move) {
        StatusEffect toApply = move.getAppliesStatus();
        if (toApply == null || toApply == StatusEffect.NONE) return;
        if (target.getStatus() != StatusEffect.NONE) {
            System.out.println("  " + target.getName() + " è già sotto effetto di uno status!");
            return;
        }
        if ((int) (Math.random() * 100) < move.getStatusChance()) {
            target.setStatus(toApply);
            System.out.printf("  %s was inflicted with %s!%n", target.getName(), toApply);
        } else {
            System.out.println("  But it failed!");
        }
    }

    /** Restituisce true se il Pokémon non può muoversi questo turno. */
    private static boolean isImmobilized(Pokemon pokemon) {
        StatusEffect s = pokemon.getStatus();
        if (s == null) return false;

        if (s == StatusEffect.SLEEP) {
            pokemon.decrementSleepCounter();
            if (pokemon.getSleepCounter() <= 0) {
                pokemon.setStatus(StatusEffect.NONE);
                System.out.println("  " + pokemon.getName() + " woke up!");
            } else {
                System.out.println("  " + pokemon.getName() + " is fast asleep!");
                return true;
            }
        }
        if (s == StatusEffect.PARALYSIS && Math.random() < 0.25) {
            System.out.println("  " + pokemon.getName() + " is paralyzed and can't move!");
            return true;
        }
        return false;
    }

    private static void applyEndOfTurnStatus(Pokemon pokemon) {
        if (pokemon == null || !pokemon.isAlive()) return;
        StatusEffect s = pokemon.getStatus();
        if (s == StatusEffect.BURN || s == StatusEffect.POISON) {
            int damage = Math.max(1, pokemon.getMaxHp() / 8);
            pokemon.takeDamage(damage);
            System.out.printf("  %s is hurt by its %s! (-%d HP)%n", pokemon.getName(), s, damage);
        }
    }

    private static Move pickEnemyMove(Pokemon enemy) {
        List<Move> usable = enemy.getMoves().stream()
                .filter(m -> m != null && m.hasPp())
                .collect(Collectors.toList());
        if (usable.isEmpty()) return null;
        return usable.get((int) (Math.random() * usable.size()));
    }

    private static boolean tryRun(Pokemon hero, Pokemon wild) {
        int chance = 50 + (hero.getSpeed() - wild.getSpeed()) * 2;
        chance = Math.max(10, Math.min(95, chance));
        return (int) (Math.random() * 100) < chance;
    }

    /**
     * Gestisce il sotto-menù oggetti durante la battaglia.
     * Restituisce true se un oggetto è stato consumato (il turno avanza).
     * Se è stata usata una Poké Ball che ha catturato il Pokémon, imposta i suoi HP a 0.
     */
    private static boolean handleItemMenu(Player player, Pokemon hero, Pokemon wild) {
        if (player.getInventory().isEmpty()) {
            System.out.println("  Il Bag è vuoto!");
            return false;
        }

        System.out.println("\n  Inventory:");
        List<String> keys = new java.util.ArrayList<>(player.getInventory().keySet());
        for (int i = 0; i < keys.size(); i++) {
            System.out.printf("  [%d] %-14s x%d%n", i + 1, keys.get(i), player.getInventory().get(keys.get(i)));
        }
        System.out.println("  [0] Cancel");
        System.out.print("  > ");
        int choice = SafeConsole.readInt(0, keys.size());
        if (choice == 0) return false;

        String itemName = keys.get(choice - 1);
        if (!player.useItem(itemName)) {
            System.out.println("  Non hai " + itemName + "!");
            return false;
        }

        switch (itemName) {
            case "Potion"       -> { new org.generation.italy.examples.pokemon.model.Potion().use(hero);      return true; }
            case "Super Potion" -> { new org.generation.italy.examples.pokemon.model.SuperPotion().use(hero); return true; }
            case "Poké Ball"    -> {
                System.out.println("  You threw a Poké Ball!");
                printShakeAnimation();
                boolean caught = CatchService.attemptCatch(wild, 1.0);
                if (caught) {
                    System.out.println("  Gotcha! " + wild.getName() + " was caught!");
                    wild.takeDamage(wild.getCurrentHp()); // segnala al loop che la cattura è avvenuta
                } else {
                    System.out.println("  Oh no! " + wild.getName() + " broke free!");
                }
                return true;
            }
            default -> {
                System.out.println("  Non puoi usare " + itemName + " in battaglia.");
                player.addItem(itemName, 1); // rimborso: l'oggetto non è stato consumato
                return false;
            }
        }
    }

    private static void printShakeAnimation() {
        System.out.print("  ");
        for (int i = 0; i < 3; i++) {
            System.out.print("*shake* ");
            try { Thread.sleep(400); } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // ripristina il flag di interruzione
            }
        }
        System.out.println();
    }

    private BattleService() {}
}