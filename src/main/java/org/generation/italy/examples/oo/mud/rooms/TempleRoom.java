package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.*;
import org.generation.italy.examples.oo.mud.items.HealPotionItem;
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
                return new HealerEntity();
            case 1:
                return new HealerEntity();
            default:
                return new GuardEntity();

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
                return new HealPotionItem();
            case 1:
                return new HealPotionItem();
            default:
                return new HealPotionItem();
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
