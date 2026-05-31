package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.entities.*;
import org.generation.italy.examples.oo.mud.items.HealPotion;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;
import java.util.Random;

public class TempleRoom extends Room {

    private static final String TITLE = "Piazza del Tempio";
    private static final String DESCRIPTION = "Qui vengono a curarsi gli avventurieri malati!";

    public TempleRoom(){
        super(TempleRoom.TITLE, TempleRoom.DESCRIPTION, getThreeRandomNpc(), getThreeRandomItems());
    }

    private static Entity getRandomNpc(){
        int randomNum = new Random().nextInt(2);

        switch (randomNum){
            case 0:
                return new HealerNpc();
            case 1:
                return new HealerNpc();
            default:
                return new GuardNpc();

        }
    }

    private static ArrayList<Entity> getThreeRandomNpc(){
        ArrayList<Entity> npcs = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            npcs.add(getRandomNpc());
        }
        return npcs;
    }

    public static Item getRandomItem(){
        int randomNum = new Random().nextInt(2);

        switch (randomNum){
            case 0:
                return new HealPotion();
            case 1:
                return new HealPotion();
            default:
                return new HealPotion();
        }
    }

    private static ArrayList<Item> getThreeRandomItems(){
        ArrayList<Item> items = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            items.add(getRandomItem());
        }
        return items;
    }
}
