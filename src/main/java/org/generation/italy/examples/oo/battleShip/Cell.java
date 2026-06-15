package org.generation.italy.examples.oo.battleShip;

public class Cell {
    private Coordinate coordinate;
    private boolean hit;
    private BoatType boat;

    public boolean isHit() {
        return hit;
    }
    public boolean hasBoat(){return boat!=null;}

}
