package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class MarketRoom extends Room {
    public MarketRoom(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {

        super(title, description, entities, items);
    }

    @Override
    public void interact(Player player) {
        System.out.println("Ciao avventuriero, vuoi comprare qualcosa?");

    }
}
