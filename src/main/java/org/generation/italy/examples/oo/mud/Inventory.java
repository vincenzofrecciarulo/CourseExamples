package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> invItems = new ArrayList<>();
    private double maxWeight;

    public Inventory() {
        this.maxWeight = -1;     // sentinel - unlimited weight - skips addItem weight check
    }

    public Inventory(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean addItem(Item item) {
        if (maxWeight > 0 && getTotalWeight() + item.getWeight() > maxWeight) {
            return false;      // too heavy
        }
        return invItems.add(item);
    }

    public boolean removeItem(Item item) {
        return invItems.remove(item);
    }

    public Item findItem(String name) {
        for (Item i : invItems) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;   // not found
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item i : invItems) {
            totalWeight += i.getWeight();
        }
        return totalWeight;
    }

    public boolean hasItem(String name) {
        for (Item i : invItems) {
            if (i.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> getItemList() {
        return new ArrayList<>(invItems);  // shallow copy, to avoid messing with the original reference by the caller
    }

    public int getItemCount() {
        return invItems.size();
    }
}
