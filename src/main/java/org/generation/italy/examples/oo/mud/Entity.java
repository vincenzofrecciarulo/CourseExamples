package org.generation.italy.examples.oo.mud;

public class Entity {
    private int hp;
    private String name;
    private int lvl;

    public Entity(int hp, String name, int lvl) {
        this.hp = hp;
        this.name = name;
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }
}
