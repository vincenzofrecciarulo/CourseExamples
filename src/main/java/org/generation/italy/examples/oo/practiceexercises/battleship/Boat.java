package org.generation.italy.examples.oo.practiceexercises.battleship;

import java.util.List;

public class Boat {
    private char direction;
    private BoatTypes type;

    private boolean present;

    public Boat( BoatTypes type) {
        this.type = type;
        present=true;
    }


    public BoatTypes getType() {
        return type;
    }

    public boolean isPresent() {
        return present;
    }
}
