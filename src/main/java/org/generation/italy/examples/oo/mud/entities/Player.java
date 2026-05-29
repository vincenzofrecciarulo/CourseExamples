package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class Player extends Entity {
    private int coins = 0;
    private ArrayList<Item> inventory = new ArrayList<>();
    private static final double MAX_WEIGHT = 2000;

    public Player(int hp, String name, int level) {
        super(hp, name, level);
    }

    public void heal(int heal){
        hp += heal;
    }

    public int getCoins(){
        return coins;
    }

    public boolean depositCoins(int coins){
        if(coins < 0){
            return false;
        }
        this.coins += coins;
        return true;
    }

    public boolean withdrawCoins(int amount){
        if(coins < amount){
            return false;
        }
        coins -= amount;
        return true;
    }

    public boolean pick(Item item){
        if(getInventoryWeight() + item.getWeight() > MAX_WEIGHT){
            return false;
        }
        inventory.add(item);
        return true;
    }

    public void drop(Item item){
        inventory.remove(item);
    }

    public double getInventoryWeight(){
        double totalWeight = 0.0;
        for (Item item : inventory){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}
