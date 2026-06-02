package org.generation.italy.examples.oo.mud;

public class Entity {
    private int hp;
    private String name;
    private int level;

    public Entity(int hp, String name, int level) {
        this.hp = hp;
        this.name = name;
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
