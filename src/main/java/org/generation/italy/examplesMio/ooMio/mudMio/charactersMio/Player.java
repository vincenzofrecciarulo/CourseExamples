package org.generation.italy.examplesMio.ooMio.mudMio.charactersMio;

import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.DndClass;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Inventory;
import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Race;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Weapon;

public class Player extends Entity {
    private Inventory inventory;
    private int coins;

    public Player(String name, Race race, String gender, DndClass dndClass, Weapon equippedWeapon, int coins) {
        super(dndClass.getHpBase(), name, 1, race, gender, dndClass, equippedWeapon);
        this.inventory = new Inventory(30, 10);
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }


    public void addGold(int amount){
        coins -= amount;
    }

    public void removeGold(int amount){
        coins -= amount;
    }

    public Inventory getInventory() {
        return inventory;
    }


}
