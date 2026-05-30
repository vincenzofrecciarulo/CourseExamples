package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Player extends Entity {
    // Attributi
    private ArrayList<Item> inventory;
    private Room currentRoom;
    private double maxWeight;
    //Costruttore
    public Player(int hp, String name, int level, Room currentPosition) {
        super(hp, name, level);
        this.currentRoom = currentPosition;
        maxWeight = 100;
        inventory = new ArrayList<>();
        inventory.add(new Item(10,15,"Spada Semplice"));
        inventory.add(new Item(1,10,"Pozione Curativa"));
    }
    // Metodi

    public boolean moveTo(int direction) {
        Room destination = currentRoom.exitAt(direction);
        if(destination != null){
            currentRoom = destination;
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

    public String pick(int itemPosition){
        int realIndex = itemPosition-1;
        if (realIndex <= 0 || realIndex > currentRoom.getEntityNames().size()){
            return "Hai inserito un indice sbagliato";
        }
        Item item = currentRoom.getItemByIndex(realIndex);
        boolean hasSuccess = tryPickItem(item);
        if (hasSuccess){
            currentRoom.removeItem(item);
            return "Aggiunto al tuo inventario " + item.getName();
        }
        return "Inventario Pieno!";
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public double getMaxWeight() {
        return maxWeight;
    }
}
