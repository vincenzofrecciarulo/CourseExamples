package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.roles.CharacterStats;

public class Monster extends Entity {
    private final CharacterStats stats;

    public Monster(int hp, String name, int level, int attackPower) {
        this(hp, name, level, new CharacterStats(Math.max(1, attackPower + 2), attackPower + 1, Math.max(1, level + 1), 2 + level / 2, 1));
    }

    public Monster(int hp, String name, int level, CharacterStats stats) {
        super(hp, name, level);
        this.stats = stats;
    }

    @Override
    public CharacterStats getStats() {
        return stats;
    }
}
