package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.GeneralMerchantEntity;
import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.GuardEntity;
import org.generation.italy.examples.oo.mud.items.HealPotionItem;
import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.items.ScrollOfReturnItem;


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
                return new HealPotionItem();
            case 1:
            default:
                return new ScrollOfReturnItem();
        }
    }

}
