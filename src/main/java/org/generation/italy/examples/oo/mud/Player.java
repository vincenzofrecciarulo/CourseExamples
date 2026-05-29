package org.generation.italy.examples.oo.mud;

public class Player extends Entity{
    private Inventory inventory;

    public Player(String name, Race race, String gender, DndClass dndClass, Weapon equippedWeapon) {
        super(dndClass.getHpBase(), name, 1, race, gender, dndClass, equippedWeapon);
        this.inventory = new Inventory(30, 10);
    }

    public Inventory getInventory() {
        return inventory;
    }

}
