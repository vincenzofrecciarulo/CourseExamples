package org.generation.italy.examples.oo.mud.entities.enemies;


import org.generation.italy.examples.oo.mud.Item;
import org.generation.italy.examples.oo.mud.Room;
import org.generation.italy.examples.oo.mud.entities.Entity;

import java.util.ArrayList;

public class Enemy extends Entity {
    private int difficulty;
    protected ArrayList<Item> loot;
    public Enemy(String name, int level, int strength, int hp,String difficulty, Room startingRoom) {
        super(name, level, strength, hp,startingRoom);
        switch(difficulty){
            case "easy":
                setLuck(0);
                break;
            case "medium":
                setLuck(10);
                break;
            case "hard":
                setLuck(50);
                break;
        }
        loot=new ArrayList<>();
    }
    public Enemy(String name, int strength, int hp, Room startingRoom) {
        this(name, 1, strength, hp,"easy", startingRoom);
    }


}
