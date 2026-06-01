package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class EmptyRoom extends Room{
    private static final String TITLE = "Empty room";
    private static final String MAP_ICON = "X";

    public EmptyRoom() {
        super(EmptyRoom.TITLE, "",  EmptyRoom.MAP_ICON);
    }
}
