package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.GeneralMerchantEntity;
import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.items.HealPotionItem;
import org.generation.italy.examples.oo.mud.items.Item;


import java.util.ArrayList;
import java.util.Random;

public class MarketRoom extends Room {
    private static final String TITLE = "Piazza del Mercato";
    private static final String DESCRIPTION = "Qua risiedono i mercanti e i nullafacenti!";
    private static final String MAP_ICON = "M";

    public MarketRoom(){
        super(TITLE, DESCRIPTION, MarketRoom.getThreeRandomNpc(), MarketRoom.getThreeRandomItems(), MarketRoom.MAP_ICON);
    }


    private static Entity getRandomNpc(){
        int randomNum = new Random().nextInt(2);

        switch (randomNum){
            case 0:
                return new GeneralMerchantEntity();
            case 1:
                return new GeneralMerchantEntity();
            default:
                return new GeneralMerchantEntity();

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
