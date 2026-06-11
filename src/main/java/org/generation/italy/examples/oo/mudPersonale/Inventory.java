package org.generation.italy.examples.oo.mudPersonale;

import org.generation.italy.examples.oo.mudPersonale.items.Item;
import org.generation.italy.examples.oo.mudPersonale.items.MapItem;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> inventory = new ArrayList<>();
    public static final double MAX_WEIGHT = 2000;


    public Inventory(){
        inventory.add(new MapItem());
    }

    public boolean add(Item item){
        if(getInventoryWeight() + item.getWeight() > MAX_WEIGHT){
            return false;
        }
        inventory.add(item);
        return true;
    }

    public void remove(Item item){
        inventory.remove(item);
    }

    public double getInventoryWeight(){
        double totalWeight = 0.0;
        for (Item item : inventory){
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public boolean showItems(){
        if(inventory.isEmpty()){
            return false;
        }
        System.out.println("Oggetti in inventario (" + getInventoryWeight() + " peso) : ");
        for(int i = 0; i < inventory.size(); i++){
            System.out.printf("(%s) %s \n", i, inventory.get(i).getName());
        }
        return true;
    }



    public Item findItem(int index){
        if(index > inventory.size()){
            return null;
        }
        return inventory.get(index);
    }
}
