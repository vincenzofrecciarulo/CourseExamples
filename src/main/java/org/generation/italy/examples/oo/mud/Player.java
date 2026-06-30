package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.roles.CharacterStats;
import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.Item;

import java.util.ArrayList;

public class Player extends Entity {

    private int minDamage;
    private int maxDamage;
    private ArrayList<Item> inventory;

    public Player(String name, String type){
        super(100,name,1);
        switch(type.toLowerCase()){
            case "comandante":
                this.minDamage=10;
                this.maxDamage=20;
                break;

            case "guerriero":
                this.minDamage=5;
                this.maxDamage=12;
                break;

            default:
                IO.println("sei un ubriacone della locanda");
                this.minDamage=2;
                this.maxDamage=6;
                break;
        }
        this.inventory = new ArrayList<Item>();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int calculateDamage(){
        int damage = (int)(Math.random() * (this.maxDamage - this.minDamage + 1)) + this.minDamage;
        return damage;
    }

    public void pickUpItem(Item item) {
        this.inventory.add(item);
        System.out.println("Hai raccolto: " + item.getName());
    }

    public void dropItem(Item item) {
        this.inventory.remove(item);
        System.out.println("Hai lasciato cadere: " + item.getName());
    }


    @Override
    public CharacterStats getStats() {
        return null;
    }
}
