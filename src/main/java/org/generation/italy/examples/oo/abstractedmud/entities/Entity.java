package org.generation.italy.examples.oo.abstractedmud.entities;

import org.generation.italy.examples.oo.abstractedmud.Room;

public abstract class Entity {
    private int hp;
    private String name;
    private Room currentRoom;

    public Entity(int hp, String name, Room currentRoom) {
        this.hp = hp;
        this.name = name;
        this.currentRoom = currentRoom;
    }

    public String getName(){return name;}
    public int getHP(){return hp;}
    public Room getCurrentRoom(){return currentRoom;}
}
