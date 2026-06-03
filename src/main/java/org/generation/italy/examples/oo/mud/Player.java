package org.generation.italy.examples.oo.mud;

public class Player extends Entity {
    private Inventory inventory;
    private int gold;

    public Player(String name) {
        super(100, name, 1);
        this.inventory = new Inventory(); // no weight limit by default
        this.gold = 0;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean addGold(int addGold) {
        gold += addGold;
        return true;
    }
}
