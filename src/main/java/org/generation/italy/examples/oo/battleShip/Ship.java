package org.generation.italy.examples.oo.battleShip;

public class Ship {
    private BoatType type;
    private boolean horizontal;
    private Coordinate coor;

    public Ship(BoatType type, boolean horizontal,) {
        this.type = type;
        this.horizontal = horizontal;
    }

    public BoatType getType() {
        return type;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public Coordinate getCoor() {
        return coor;
    }
}
