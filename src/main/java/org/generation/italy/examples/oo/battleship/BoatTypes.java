package org.generation.italy.examples.oo.battleship;

public enum BoatTypes {
    BIG(5),MEDIUM(3),SMALL(1);
    private int dimension;

    BoatTypes(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }
}
