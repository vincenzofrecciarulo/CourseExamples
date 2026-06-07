package org.generation.italy.examples.oo.mud;

public class NPC extends Entity{
    private String dialogue;

    public NPC(int hp, String name, int level, int attack, int defense, String dialogue) {
        super(hp, name, level, attack, defense, false);
        this.dialogue = dialogue;
    }

    public String getDialogue() {
        return dialogue;
    }
}
