package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class Player extends Entity {
    private int coins = 0;
    private ArrayList<Item> inventory = new ArrayList<>();

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

    public void pick(Item item){
        inventory.add(item);
    }

    public void drop(int index){
        inventory.remove(index);
    }
}
