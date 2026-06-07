package org.generation.italy.examples.oo.mudPersonale.rooms;

import org.generation.italy.examples.oo.mudPersonale.entities.npc.GeneralMerchantEntity;
import org.generation.italy.examples.oo.mudPersonale.entities.Entity;


import java.util.ArrayList;

public class ShopRoom extends Room {
    private static final String TITLE = "Piazza del Mercato";
    private static final String DESCRIPTION = "Qua risiedono i mercanti e i nullafacenti!";
    private static final String MAP_ICON = "M";

    public ShopRoom(){
        super(TITLE, DESCRIPTION,  ShopRoom.MAP_ICON);
    }

    @Override
    protected ArrayList<Entity> spawnEntities(){
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(new GeneralMerchantEntity());
        return entities;
    }


}
