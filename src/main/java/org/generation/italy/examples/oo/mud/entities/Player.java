package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.Map;
import org.generation.italy.examples.oo.mud.enums.Direction;
import org.generation.italy.examples.oo.mud.items.Item;

import org.generation.italy.examples.oo.mud.rooms.EmptyRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;

public class Player extends Entity {
    private int coins;
    private final Inventory inventory;
    private int currentY = 10;
    private int currentX = 10;

    public Player(int hp, String name, int level, int coins, Inventory inventory) {
        super(hp, name, level);
        this.coins = coins;
        this.inventory = inventory;
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

    public Room getCurrentRoom(Map map){
        return map.getRoom(currentY, currentX);
    }

    public void moveTo(Map map, Direction direction){
        switch(direction) {
            case Direction.NORTH:
                if(currentY - 1 < 0 || map.getRoom(currentY-1, currentX) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }
                if(map.getRoom(currentY - 1, currentX) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room, currentY - 1, currentX);
                }
                if(!(map.getRoom(currentY - 1, currentX) instanceof EmptyRoom)){
                    currentY--;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            case Direction.SOUTH:
                if(currentY + 1 >= 20 || map.getRoom(currentY + 1,currentX) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }
                if(map.getRoom(currentY + 1,currentX) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room,currentY + 1,currentX);

                }
                if(!(map.getRoom(currentY + 1,currentX) instanceof EmptyRoom)){
                    currentY++;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            case Direction.EAST:
                if(currentX + 1 >= 20 || map.getRoom(currentY,currentX + 1) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }
                if(map.getRoom(currentY,currentX + 1) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room,currentY,currentX + 1);

                }
                if(!(map.getRoom(currentY, currentX + 1) instanceof EmptyRoom)){
                    currentX++;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            case Direction.WEST:
                if(currentX - 1 < 0 || map.getRoom(currentY,currentX - 1) instanceof EmptyRoom){
                    Room.showDeadEnd();
                    break;
                }

                if(map.getRoom(currentY, currentX - 1) == null){
                    Room room = Room.getRandomRoom();
                    map.setRoom(room,currentY,currentX - 1);
                }
                if(!(map.getRoom(currentY,currentX - 1) instanceof EmptyRoom)){
                    currentX--;
                    IO.println("Stai correndo...");
                }else{
                    Room.showDeadEnd();
                }
                break;
            default:
                break;
        }
    }

    public void teleportToStart(){
        currentX = 10;
        currentY = 10;
    }

}
