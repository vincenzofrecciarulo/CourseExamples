package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.entities.BlacksmithNpc;
import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.HealPotion;
import org.generation.italy.examples.oo.mud.items.ScrollOfReturn;

import java.util.ArrayList;
import java.util.Random;

public class MarketRoom extends Room {
    private static final String TITLE = "Piazza del Mercato";
    private static final String DESCRIPTION = "Qui vengono a curarsi gli avventurieri malati!";

    public MarketRoom(){
        super(TITLE, DESCRIPTION, MarketRoom.getThreeRandomNpc(), new ArrayList<>());

    }

    @Override
    public void interact(Player player) {
        String input = IO.readln("Vuoi interagire con un npc (1) o raccogliere degli oggetti (2) ?");

        switch (input){
            case "1":
                int index = Integer.parseInt(IO.readln("Inserisci l'npc con cui vuoi interagire."));
                getEntity(index).interact(player);
                break;
            default:
                break;
        }

    }

    private static Entity getRandomNpc(){
        int randomNum = new Random().nextInt(2);

        switch (randomNum){
            case 0:
                return new BlacksmithNpc();
            case 1:
                return new BlacksmithNpc();
            default:
                return new BlacksmithNpc();

        }
    }

    private static ArrayList<Entity> getThreeRandomNpc(){
        ArrayList<Entity> npcs = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            npcs.add(getRandomNpc());
        }
        return npcs;
    }

}
