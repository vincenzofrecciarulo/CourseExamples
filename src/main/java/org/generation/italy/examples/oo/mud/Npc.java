package org.generation.italy.examples.oo.mud;

public class Npc extends Entity {
    private final String dialogue;

    public Npc(int hp, String name, int level, String dialogue) {
        super(hp, name, level);
        this.dialogue = dialogue;
    }

    public String getDialogue() {
        return dialogue;
    }

    public String speak() {
        return dialogue;
    }
}
