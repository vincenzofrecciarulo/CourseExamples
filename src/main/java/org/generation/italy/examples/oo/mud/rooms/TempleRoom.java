package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.*;
import org.generation.italy.examples.oo.mud.items.HealPotionItem;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.Random;

public class TempleRoom extends Room {

    private static final String TITLE = "Piazza del Tempio";
    private static final String DESCRIPTION = "Qui vengono a curarsi gli avventurieri malati!";
    private static final String MAP_ICON = "T";

    public TempleRoom(){
        super(TempleRoom.TITLE, TempleRoom.DESCRIPTION, TempleRoom.MAP_ICON);
    }

    @Override
    protected Entity getRandomNpc(){
        int randomNum = new Random().nextInt(3);

        switch (randomNum){
            case 0:
                return new HealerEntity();
            case 1:
                return new HealerEntity();
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
                return new HealPotionItem();
            default:
                return new HealPotionItem();
        }
    }

}
