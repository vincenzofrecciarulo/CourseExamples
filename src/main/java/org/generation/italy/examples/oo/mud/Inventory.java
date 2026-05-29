package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private double maxWeight;
    private int maxSlot;

    public Inventory(double maxWeight, int maxSlot) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.maxSlot = maxSlot;
    }

    public double getCurrentWeight(){
        double totalWeight = 0;
        for(Item item : items){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public void addItem(Item item){
        if(items.size() < maxSlot && getCurrentWeight() + item.getWeight() <= maxWeight){
            items.add(item);
        }
    }

    public void removeItem(Item item){
        items.remove(item);
    }
}
