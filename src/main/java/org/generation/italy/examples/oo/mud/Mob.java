package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Mob extends Entity{
    private int expPoints;
    private Item loot;

    public Mob(int hp, String name, int level, int attack, int defense, int expPoints, Item loot) {
        super(hp, name, level, attack, defense, true);
        this.expPoints = expPoints;
        this.loot = loot;
    }

    public int getExpPoints() {
        return expPoints;
    }

    public Item getLoot() {
        return loot;
    }
}
