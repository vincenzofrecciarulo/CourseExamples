package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class TempleRoom extends Room {
    private static final int HEAL_AMOUNT = 100;

    public TempleRoom(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {
        super(title, description, entities, items);
    }

    @Override
    public void interact(Player player){
        String input = IO.readln("Vuoi riposare nel mio per 5 monete?");
        if(input.equals("y")){
            System.out.println("Stai riposando nel tempo...");
            player.heal(HEAL_AMOUNT);
            System.out.println("Hai recuperato 100 punti vita.");
        }
    }


}
