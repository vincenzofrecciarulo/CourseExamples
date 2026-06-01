package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.enemies.Enemy;
import org.generation.italy.examples.oo.mud.entities.enemies.Goblin;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class DangerRoom extends Room{
    private static final String TITLE = "Foresta oscura";
    private static final String DESCRIPTION = "Qui risiedono mostri pericolosi";
    private static final String MAP_ICON = "D";

    public DangerRoom() {
        super(DangerRoom.TITLE, DangerRoom.DESCRIPTION, DangerRoom.MAP_ICON);
    }

    @Override
    protected Entity getRandomNpc(){
        return new Goblin(20, "Goblin", 2);
    }
}
