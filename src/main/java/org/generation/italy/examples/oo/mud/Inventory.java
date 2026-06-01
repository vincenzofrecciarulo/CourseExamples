package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.items.MapItem;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> inventory = new ArrayList<>();
    public static final double MAX_WEIGHT = 2000;


    public Inventory(){
        inventory.add(new MapItem());
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

    public boolean useItem(int index, Player player){
        if(index >= 0 && index < inventory.size()){
            inventory.get(index).interact(player);
            return true;
        }
        return false;
    }
}
