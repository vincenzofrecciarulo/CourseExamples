package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> inventory = new ArrayList<>();
    public static final double MAX_WEIGHT = 2000;


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
