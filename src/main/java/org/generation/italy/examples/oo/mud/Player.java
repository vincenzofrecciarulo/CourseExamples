package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Player extends Entity{
    ArrayList<Item> inventory;
    int gold;

    public Player(int hp, String name, int level, int attack, int defense, boolean hostile) {
        super(hp, name, level, attack, defense,hostile);
        this.inventory = new ArrayList<>();
        this.gold = 0;
    }
}
