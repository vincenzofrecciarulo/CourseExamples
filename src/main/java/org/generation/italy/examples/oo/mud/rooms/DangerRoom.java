package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class DangerRoom extends Room{
    private static final String TITLE = "Foresta oscura";
    private static final String DESCRIPTION = "Qui risiedono mostri pericolosi";

    public DangerRoom() {
        super(DangerRoom.TITLE, DangerRoom.DESCRIPTION, new ArrayList<>(), new ArrayList<>());
    }
}
