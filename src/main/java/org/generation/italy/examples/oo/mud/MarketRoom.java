package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class MarketRoom extends Room{
    public MarketRoom(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {

        super(title, description, entities, items);
    }

    @Override
    public void interact(Player player) {
        System.out.println("Ciao avventuriero, vuoi comprare qualcosa?");

    }
}
