package org.generation.italy.examples.oo.mudPersonale.rooms;

public class EmptyRoom extends Room{
    private static final String TITLE = "Empty room";
    private static final String MAP_ICON = "X";

    public EmptyRoom() {
        super(EmptyRoom.TITLE, "",  EmptyRoom.MAP_ICON);
    }
}
