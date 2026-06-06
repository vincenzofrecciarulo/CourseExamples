package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.List;


public class Inventory {

     private List<Item> items;
     private static final int maxWeight=20;
     private double currentWeight;

    public Inventory() {
        this.items = new ArrayList<>();
        this.currentWeight = 0;

    }

    public List<Item> getBackPack() {
        return items;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Hai i seguenti oggetti");
        sb.append(getItemsNames());
        return sb.toString();
    }

    public Item findItem(String itemSearched,Player player){
        for(Item item: items){
            if(itemSearched.equalsIgnoreCase(item.getName())){
                return item;
            }
        }
        return null;

    }
    public boolean addItem(Item itemAdded){
        if(currentWeight+itemAdded.getWeight()>maxWeight){
            IO.println("Inventario pieno togli qualcosa");
            return false;
        }else {
            items.add(itemAdded);
            currentWeight+=itemAdded.getWeight();
        }
        return true;
    }
    public void removeItem(Item itemRemoved){
        items.remove(itemRemoved);
        if(itemRemoved!=null){
            items.remove(itemRemoved);
            currentWeight-=itemRemoved.getWeight();
            return;
        }
        IO.println("Impossibile rimuovere,oggetto inesistente");
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public List<String> getItemsNames(){
        List<String> names = new ArrayList<>();
        for(Item item:items){
            names.add(item.getName());
        }
        return names;
    }
}
