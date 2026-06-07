package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Player extends Entity{
    private Inventory inventory;
    int gold;

    public Player(int hp, String name, int level, int attack, int defense) {
        super(hp, name, level, attack, defense, false);
        this.inventory = new Inventory();
        this.gold = 0;
    }

    public boolean pickUp(Item item){
        inventory.addItem(item);
        return true;
    }

    public boolean dropItem(Item item){
        inventory.removeItem(item);
        return true;
    }
}
