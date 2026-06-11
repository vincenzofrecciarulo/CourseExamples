package org.generation.italy.examples.pokemon.service;

import org.generation.italy.examples.pokemon.model.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokedexService {

    /** Prints a full Pokédex entry to the console. */
    public static void display(PokedexEntry entry) {
        if (entry == null) { System.out.println("Pokémon not found!"); return; }
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.printf( "║  #%03d %-48s║%n", entry.getNumber(), entry.getName());
        System.out.println("╠══════════════════════════════════════════════════════╣");

        // Types
        StringBuilder types = new StringBuilder("Type: ");
        for (PokemonType t : entry.getTypes()) types.append(t).append("  ");
        System.out.printf("║  %-52s║%n", types.toString().trim());

        // Base stats
        BaseStats s = entry.getBaseStats();
        System.out.println("║  Base Stats:                                         ║");
        System.out.printf( "║    HP:%-3d  ATK:%-3d  DEF:%-3d  SpA:%-3d  SpD:%-3d  SPE:%-3d ║%n",
                s.getHp(), s.getAttack(), s.getDefense(), s.getSpAttack(), s.getSpDefense(), s.getSpeed());

        // Evolution
        if (entry.canEvolve()) {
            System.out.printf("║  Evolves at Lv.%-37d║%n", entry.getEvolutionLevel());
        } else {
            System.out.printf("║  %-52s║%n", "Does not evolve.");
        }

        // Learnset
        System.out.println("║  Learnset:                                           ║");
        for (PokedexEntry.LearnEntry le : entry.getLearnset()) {
            System.out.printf("║    Lv.%-3d %-44s║%n", le.level, le.moveTemplate.getName());
        }

        // Description
        System.out.println("╠══════════════════════════════════════════════════════╣");
        printWrapped(entry.getDescription(), 52);
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    /** Lists all entries in number order with a one-line summary. */
    public static void listAll(Pokedex pokedex) {
        List<PokedexEntry> sorted = pokedex.all().stream()
                .sorted(Comparator.comparingInt(PokedexEntry::getNumber))
                .collect(Collectors.toList());
        System.out.println("\n──── Pokédex (" + sorted.size() + " entries) ────");
        for (PokedexEntry e : sorted) {
            StringBuilder types = new StringBuilder();
            for (PokemonType t : e.getTypes()) types.append(t).append("/");
            types.deleteCharAt(types.length() - 1);
            System.out.printf("  #%03d %-12s [%s]%n", e.getNumber(), e.getName(), types);
        }
    }

    private static void printWrapped(String text, int width) {
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder("║  ");
        for (String word : words) {
            if (line.length() + word.length() + 1 > width + 3) {
                System.out.printf("%-" + (width + 3) + "s║%n", line.toString());
                line = new StringBuilder("║  ").append(word).append(" ");
            } else {
                line.append(word).append(" ");
            }
        }
        if (line.length() > 3) {
            System.out.printf("%-" + (width + 3) + "s║%n", line.toString());
        }
    }

    private PokedexService() {}
}