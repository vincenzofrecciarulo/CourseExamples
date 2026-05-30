package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class EmptyRoom extends Room{
    private static final String TITLE = "Empty room";

    public EmptyRoom() {
        super(EmptyRoom.TITLE, "", new ArrayList<>(), new ArrayList<>());
    }
}
