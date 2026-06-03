package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Inventory {

     private ArrayList<Item> backPack;
     private static final int maxWeight=20;
     private double currentWeight;

    public Inventory() {
        this.backPack = new ArrayList<>();
        this.currentWeight = 0;

    }

    public ArrayList<Item> getBackPack() {
        return backPack;
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
        for(Item item: backPack){
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
            backPack.add(itemAdded);
            currentWeight+=itemAdded.getWeight();
        }
        return true;
    }
    public boolean removeItem(Item itemRemoved){
        backPack.remove(itemRemoved);
        if(itemRemoved!=null){
            backPack.remove(itemRemoved);
            currentWeight-=itemRemoved.getWeight();
            return true;
        }
        IO.println("Impossibile rimuovere,oggetto inesistente");
        return false;
    }
    public boolean isEmpty(){
        return backPack.isEmpty();
    }
    public ArrayList<String> getItemsNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Item item:backPack){
            names.add(item.getName());
        }
        return names;
    }
}
