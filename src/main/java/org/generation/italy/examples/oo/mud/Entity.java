package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Entity {

    private int hp;
    private String name;
    private int level;
    private Inventory inventory;

    public Entity(int hp, String name, int level) {
        this.hp = hp;
        this.name = name;
        this.level = level;
    }
    public Entity(){}

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
