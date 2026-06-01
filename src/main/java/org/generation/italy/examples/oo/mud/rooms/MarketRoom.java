package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.npc.GeneralMerchantEntity;
import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.npc.GuardEntity;
import org.generation.italy.examples.oo.mud.items.HealPotion;
import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.items.ScrollOfReturn;


import java.util.Random;

public class MarketRoom extends Room {
    private static final String TITLE = "Piazza del Mercato";
    private static final String DESCRIPTION = "Qua risiedono i mercanti e i nullafacenti!";
    private static final String MAP_ICON = "M";

    public MarketRoom(){
        super(TITLE, DESCRIPTION,  MarketRoom.MAP_ICON);
    }

    @Override
    protected Entity getRandomNpc(){
        int randomNum = new Random().nextInt(2);

        switch (randomNum){
            case 0:
                return new GeneralMerchantEntity();
            case 1:
            default:
                return new GuardEntity();

        }
    }



    @Override
    protected Item getRandomItem(){
        int randomNum = new Random().nextInt(2);

        switch (randomNum){
            case 0:
                return new HealPotion();
            case 1:
            default:
                return new ScrollOfReturn();
        }
    }

}
