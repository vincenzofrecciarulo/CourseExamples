package org.generation.italy.examples.oo.mudPersonale.rooms;

import org.generation.italy.examples.oo.mudPersonale.entities.*;
import org.generation.italy.examples.oo.mudPersonale.entities.npc.GeneralMerchantEntity;
import org.generation.italy.examples.oo.mudPersonale.entities.npc.HealerEntity;

import java.util.ArrayList;

public class PokecenterRoom extends Room {

    private static final String TITLE = "Piazza del Tempio";
    private static final String DESCRIPTION = "Qui vengono a curarsi gli avventurieri malati!";
    private static final String MAP_ICON = "T";

    public PokecenterRoom(){
        super(PokecenterRoom.TITLE, PokecenterRoom.DESCRIPTION, PokecenterRoom.MAP_ICON);
    }

    @Override
    protected ArrayList<Entity> spawnEntities(){
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(new HealerEntity());
        entities.add(new GeneralMerchantEntity());
        return entities;
    }


}
