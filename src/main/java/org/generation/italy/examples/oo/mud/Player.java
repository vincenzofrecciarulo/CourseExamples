package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Player extends Entity {
    // Attributi
    private ArrayList<Item> inventory;
    private Room currentPosition;
    private double maxWeight;
    //Costruttore
    public Player(int hp, String name, int level, Room currentPosition) {
        super(hp, name, level);
        this.currentPosition = currentPosition;
        maxWeight = 100;
        inventory = new ArrayList<>();
        inventory.add(new Item(10,15,"Spada Semplice"));
        inventory.add(new Item(1,10,"Pozione Curativa"));
    }
    // Metodi

    public boolean moveTo(int direction) {
        Room destination = currentPosition.exitAt(direction);
        if(destination != null){
            currentPosition = destination;
            return true;
        }
        return false;
    }

    // metodo che controlla se abbiamo spazio nell'inventario tramite il peso
    public double spaceLeftByWeight(){
        double sumWeight = 0;
        for(Item i : inventory){
            sumWeight += i.getWeight();
        }
        return maxWeight - sumWeight;
    }

    // metodo che tramite il controllo del peso, ci indica se aggiungere o meno all'inventario l'oggetto in input
    public boolean tryPickItem(Item item){
        double spaceLeft = spaceLeftByWeight();
        if (spaceLeft < item.getWeight()){
            return false;
        }
        inventory.add(item);
        return true;
    }

    // metodo che prende in input un indice e rimuove l'oggetto dell'inventario
    public boolean tryDropItem(int index){
        if (index > inventory.size() || index <= 0) return false;
        inventory.remove(index -1);
        return true;
    }

    // metodo di stampa dell'inventario con indici
    public void inventoryToString(){
        for (Item i : inventory){
            int realIndex = inventory.indexOf(i) + 1;
            IO.println(realIndex + " " + i.getName());
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Room currentPosition) {
        this.currentPosition = currentPosition;
    }

    public double getMaxWeight() {
        return maxWeight;
    }
}
