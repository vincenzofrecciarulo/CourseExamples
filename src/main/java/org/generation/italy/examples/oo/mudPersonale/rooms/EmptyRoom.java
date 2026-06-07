package org.generation.italy.examples.oo.mudPersonale.rooms;

import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.items.Item;

import java.util.ArrayList;

public class EmptyRoom extends Room{
    private static final String TITLE = "Empty room";
    private static final String MAP_ICON = "X";

    public EmptyRoom() {
        super(EmptyRoom.TITLE, "",  EmptyRoom.MAP_ICON);
    }


    @Override
    protected ArrayList<Entity> spawnEntities() {
        return null;
    }
}
