package org.generation.italy.examples.oo.abstractedmud.entities;

import org.generation.italy.examples.oo.abstractedmud.Room;

public class Player extends Entity{
    private int strength;
    private int shield;
    private final int INVENTORY_SLOTS=20;
    private final int MAX_WEIGHT=50;
    private int weight;

    public Player(String name,int hp, Room startingRoom) {
        super(hp, name, startingRoom);
    }
}
