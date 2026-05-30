package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.roles.CharacterStats;

public class Npc extends Entity {
    private final String dialogue;
    private final CharacterStats stats;

    public Npc(int hp, String name, int level, String dialogue) {
        this(hp, name, level, new CharacterStats(4, 4, 4, 4, 4), dialogue);
    }

    public Npc(int hp, String name, int level, CharacterStats stats, String dialogue) {
        super(hp, name, level);
        this.dialogue = dialogue;
        this.stats = stats;
    }

    public String getDialogue() {
        return dialogue;
    }

    public String speak() {
        return dialogue;
    }

    @Override
    public CharacterStats getStats() {
        return stats;
    }
}
