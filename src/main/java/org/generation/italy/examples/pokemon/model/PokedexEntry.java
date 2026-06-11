package org.generation.italy.examples.pokemon.model;

import java.util.List;

public class PokedexEntry {

    /** A single learnset row: learn this move at this level. */
    public static class LearnEntry {
        public final int level;
        public final Move moveTemplate;

        public LearnEntry(int level, Move moveTemplate) {
            this.level = level;
            this.moveTemplate = moveTemplate;
        }
    }

    private final int number;
    private final String name;
    private final PokemonType[] types;
    private final BaseStats baseStats;
    private final List<LearnEntry> learnset; // sorted by level ascending
    private final int evolutionLevel;        // -1 = no evolution
    private final int evolutionNumber;       // dex number of evolution
    private final String description;
    private final int catchRate;             // 0-255
    private final int baseXpYield;

    public PokedexEntry(int number, String name, PokemonType[] types, BaseStats baseStats,
                        List<LearnEntry> learnset, int evolutionLevel, int evolutionNumber,
                        String description, int catchRate, int baseXpYield) {
        this.number = number;
        this.name = name;
        this.types = types;
        this.baseStats = baseStats;
        this.learnset = learnset;
        this.evolutionLevel = evolutionLevel;
        this.evolutionNumber = evolutionNumber;
        this.description = description;
        this.catchRate = catchRate;
        this.baseXpYield = baseXpYield;
    }

    public int getNumber()          { return number; }
    public String getName()         { return name; }
    public PokemonType[] getTypes() { return types; }
    public BaseStats getBaseStats() { return baseStats; }
    public List<LearnEntry> getLearnset() { return learnset; }
    public int getEvolutionLevel()  { return evolutionLevel; }
    public int getEvolutionNumber() { return evolutionNumber; }
    public boolean canEvolve()      { return evolutionLevel > 0; }
    public String getDescription()  { return description; }
    public int getCatchRate()       { return catchRate; }
    public int getBaseXpYield()     { return baseXpYield; }
}