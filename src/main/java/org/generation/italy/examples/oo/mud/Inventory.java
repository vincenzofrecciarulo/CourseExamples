package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Inventory {
    public ArrayList<Item> items;          //Poi renderlo che cambia
    public double maxWeight;
    public double weight;

    public Inventory(ArrayList<Item> items, double weight, double maxWeight){
        this.items = items;
        this.weight = weight;
        this.maxWeight = weight;
    }




    public boolean addToInventory(Item item){
        if ((weight+item.getWeight())>maxWeight) {
            return false;
        }
        items.add(item);
        weight+=item.getWeight();
        return true;
    }

    public void printInventory(){              //Far sì che stampa in tabella ordinata tutti item e dati, e weight/maxWeight
        for (Item i : items) {
//            System.out.println(items.get().getName());
        }
    }

    public double getWeight(){
        return weight;
    }

    public double getMaxWeight(){
        return maxWeight;
    }

    public Item dropFromInventory(int index){
        if (index > 0 && index < items.size()) {        //controllare se dev'essere .size o .size-1
            weight-= ((items.get(index)).getWeight());
            Item itemCopy = items.get(index);
            items.remove(index);
            return itemCopy;
        } else
            return null;
    }
}
