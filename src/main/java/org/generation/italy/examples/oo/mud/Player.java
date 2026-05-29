package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Player  extends Entity{

    private ArrayList<Item> inventory = new ArrayList<Item>();

    private Room currentRoom;

    public Player (int hp ,String name, int level,Room currentRoom){
        super( hp, name,  level);
        this.currentRoom = currentRoom;
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

    public boolean pickItem (Item item){
        if((!(currentRoom.getItems().contains(item)))){
            System.out.println("Oggetto"+item.getName()+"non c'è nella stanza");
            return false;
        }
        currentRoom.getItems().remove(item);
        inventory.add(item);
        return true;
    }
    public boolean WearArmor(Armor armor){

    }

    public boolean dropItem (Item item){
        if(!(inventory.contains(item))){
            System.out.println("Oggetto"+item.getName()+"non trovato");
            return false;
        }
        inventory.remove(item);
        currentRoom.getItems().add(item);
        return true;
    }

    public void printInventory(){
        ArrayList<String> itemNames = new ArrayList<>();
        for (Item i : inventory){

        }
    }


}
