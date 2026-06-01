package org.generation.italy.examples.oo.mud.roles;

import java.util.List;
import java.util.Random;

public abstract class CharacterClass {
    private final String name;
    private final String description;
    private final CharacterStats baseStats;
    private final int baseHitPoints;
    private final int statVariance;

    protected CharacterClass(String name, String description, CharacterStats baseStats, int baseHitPoints,
                             int statVariance) {
        this.name = name;
        this.description = description;
        this.baseStats = baseStats;
        this.baseHitPoints = baseHitPoints;
        this.statVariance = statVariance;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CharacterStats generateStats(Random random) {
        return new CharacterStats(
                vary(random, baseStats.getIntelligence()),
                vary(random, baseStats.getStrength()),
                vary(random, baseStats.getStamina()),
                vary(random, baseStats.getAgility()),
                vary(random, baseStats.getWisdom())
        );
    }

    public int calculateInitialHitPoints(CharacterStats stats) {
        return baseHitPoints + stats.getStamina() * 4;
    }

    public abstract List<SpecialAbility> createSpecialAbilities();

    private int vary(Random random, int baseValue) {
        int delta = random.nextInt(statVariance * 2 + 1) - statVariance;
        int scaledValue = baseValue * 2 + delta;
        return Math.max(1, Math.min(21, scaledValue));
    }
}
