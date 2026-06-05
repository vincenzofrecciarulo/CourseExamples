package org.generation.italy.examples.oo.mudPersonale.rooms;

import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.items.Item;

public class EmptyRoom extends Room{
    private static final String TITLE = "Empty room";
    private static final String MAP_ICON = "X";

    public EmptyRoom() {
        super(EmptyRoom.TITLE, "",  EmptyRoom.MAP_ICON);
    }

    @Override
    protected Entity getRandomNpc() {
        return null;
    }

    @Override
    protected Item getRandomItem() {
        return null;
    }
}
