package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Player extends Entity {
    // Attributi
    private ArrayList<Item> inventory;
    private Room currentRoom;
    private final double maxWeight;
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

    // metodo per muoversi tramite una direzione
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

    // Metodo per prendere un oggetto tramite l'indice
    public String pick(int itemPosition){
        // indice reale dell'item
        int realIndex = itemPosition-1;
        // controllo valori dell'indice errati
        if (realIndex <= 0 || realIndex > currentRoom.getEntityNames().size()){
            return "Hai inserito un indice sbagliato";
        }

        // indice giusto chiamiamo il metodo per prendere l'item
        Item item = currentRoom.getItemByIndex(realIndex);
        // metodo per controllare se possiamo aggiungere l'oggetto
        boolean hasSuccess = tryPickItem(item);
        // se ha successo aggiungiamo
        if (hasSuccess){
            currentRoom.removeItem(item);
            return "Aggiunto al tuo inventario " + item.getName();
        }
        return "Inventario Pieno!";
    }

    // metodo che prende in input un indice e controlla se l'indice è corretto
    public boolean tryDropItem(int index){
        return index <= inventory.size() && index > 0;
    }

    // Metodo che rimuove l'oggetto dall'inventario del player e lo restituisce
    public Item dropItem(int index){
        int realIndex = index -1;
        return inventory.remove(realIndex);
    }

    // metodo di stampa dell'inventario con indici
    public void inventoryToString(){
        for (Item i : inventory){
            int realIndex = inventory.indexOf(i) + 1;
            IO.println(realIndex + " " + i.getName());
        }
    }

    // Metodo che mostra l'item con tutti i suo parametri
    public String showItem(int index){
        int realIndex = index -1;
        if (index <= inventory.size() && index > 0){
            Item item = inventory.get(realIndex);
            StringBuilder sb = new StringBuilder(item.getName());
            sb.append("\n").append("Valore: ").append(item.getValue())
                    .append("\n").append("Peso ").append(item.getWeight());
            return sb.toString();
        }
        return "Elemento non trovato!";
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(this.getName());
        sb.append("\n").append("Punti salute: ").append(this.getHp())
                .append("\n").append("Livello: ").append(this.getLevel())
                .append("\n").append("Ti trovi: ").append(this.getCurrentRoom().getTitle());
        return sb.toString();
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
