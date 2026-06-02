package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Player extends Entity{
    ArrayList<Item> inventory;
    int gold;

    public Player(int hp, String name, int level) {
        super(hp, name, level);
        this.inventory = inventory;
        this.gold = 0;
    }
}
