package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.rooms.EmptyRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;

import java.util.ArrayList;

public class Player extends Entity {
    private int coins;
    private ArrayList<Item> inventory = new ArrayList<>();
    public static final double MAX_WEIGHT = 2000;
    private Room currentRoom;

    public Player(int hp, String name, int level, Room currentRoom, int coins) {
        super(hp, name, level);
        this.currentRoom = currentRoom;
        this.coins = coins;
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
