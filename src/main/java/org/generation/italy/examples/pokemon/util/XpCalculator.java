package org.generation.italy.examples.pokemon.util;

public class XpCalculator {

    /** XP gained from defeating a wild Pokémon (simplified). */
    public static int xpGain(int enemyLevel, int baseXpYield) {
        return Math.max(1, (baseXpYield * enemyLevel) / 7);
    }

    /**
     * Returns the total XP needed to reach the given level (medium-fast growth: level^3).
     * E.g. xpForLevel(5) = 125, xpForLevel(6) = 216.
     */
    public static int xpForLevel(int level) {
        return level * level * level;
    }

    /**
     * Returns how much additional XP is needed to go from currentLevel to the next level,
     * given the Pokémon's accumulated XP so far.
     */
    public static int xpToNextLevel(int currentLevel, int currentXp) {
        return xpForLevel(currentLevel + 1) - currentXp;
    }

    private XpCalculator() {}
}