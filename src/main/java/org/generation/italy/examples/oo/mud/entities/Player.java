package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.rooms.EmptyRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;

public class Player extends Entity {
    private int coins;
    private final Inventory inventory;
    private Room currentRoom;

    public Player(int hp, String name, int level, Room currentRoom, int coins, Inventory inventory) {
        super(hp, name, level);
        this.currentRoom = currentRoom;
        this.coins = coins;
        this.inventory = inventory;
    }

    public void interact(){
        currentRoom.interact(this);
    }

    public void heal(int heal){
        hp += heal;
    }

    public int getCoins(){
        return coins;
    }

    public boolean depositCoins(int coins){
        if(coins < 0){
            return false;
        }
        this.coins += coins;
        return true;
    }


    public boolean withdrawCoins(int amount){
        if(coins < amount){
            return false;
        }
        coins -= amount;
        return true;
    }

    public boolean pick(Item item){
        return inventory.pick(item);
    }

    public void drop(Item item){
        inventory.drop(item);
    }

    public boolean showItems(){
        return inventory.showItems();
    }

    public boolean useItem(int index){
        return inventory.useItem(index, this);
    }

    public double getInventoryWeight(){
        return inventory.getInventoryWeight();
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    public boolean tryMoveTo(int direction) {
        Room destination = currentRoom.exitAt(direction);
        if(destination == null){
            Room newRoom = Room.getRandomRoom();
            currentRoom.addExit(newRoom, direction);
            if(newRoom.getTitle().equals(EmptyRoom.TITLE)){
                return false;
            }
            setCurrentRoom(newRoom);
            return true;
        }
        if(destination.getTitle().equals(EmptyRoom.TITLE)){
            return false;
        }
        setCurrentRoom(destination);
        return true;
    }
}
