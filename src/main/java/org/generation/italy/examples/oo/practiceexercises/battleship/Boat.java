package org.generation.italy.examples.oo.practiceexercises.battleship;

import java.util.List;

public class Boat {
    private char direction;
    private BoatTypes type;
    private List<Coordinate>coordinates;
    private boolean present;

    public Boat(char direction, BoatTypes type, List<Coordinate> coordinates) {
        this.direction = direction;
        this.type = type;
        this.coordinates = coordinates;
        present=true;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public BoatTypes getType() {
        return type;
    }

    public boolean isPresent() {
        return present;
    }
}
