package org.generation.italy.examples.arrays.Battaglia;

public class Ship {
    private ShipType type;
    private int hits;

    public Ship(ShipType type) {
        this.hits = 0;
        this.type = type;
    }

    public void recordHit() {
        if (hits < type.getSize()) {
            hits++;
        }
    }

    public boolean isSunk() {
        return hits >= type.getSize();
    }

    public int getSize() {
        return type.getSize();
    }
}
