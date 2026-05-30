package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.Random;

public class Entity {
    private int hp;
    private String name="";
    private int level;
    private int strength;
    private Random luck=new Random();
    private Room currentRoom;
    public Entity(String name,int level,int strength,int hp,Room startingRoom){
        this.name=name;
        this.level=level;
        this.strength=strength;
        this.hp=hp;
        this.currentRoom=startingRoom;
    }
    public int levelUp(int levels){
        level+=levels;
        return level;
    }
    public boolean moveTo(String direction){
        boolean moved=false;
        Room destination= currentRoom.getExitAt(direction);
        if(destination==null) return moved;
        this.setCurrentRoom(destination);
        moved=true;
        return moved;

    }
    public void setCurrentRoom(Room destination){
        this.currentRoom=destination;
    }
    public int getHp() {
        return hp;
    }
    public String getName() {
        return name;
    }
    public int getLevel(){
        return level;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }

}
