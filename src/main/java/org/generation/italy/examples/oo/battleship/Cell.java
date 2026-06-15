package org.generation.italy.examples.oo.battleship;

public class Cell {
    private Boat boat;
    private boolean hit;

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public Boat getBoat() {
        return boat;
    }

    public boolean isHit() {
        return hit;
    }
}
