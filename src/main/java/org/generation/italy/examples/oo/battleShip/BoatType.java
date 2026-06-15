package org.generation.italy.examples.oo.battleShip;

public enum BoatType {
    EXTRA_SMALL(1), SMALL(2), MEDIUM(4), LARGE(6), EXTRA_LARGE(10);
    BoatType(int size){
        this.size =size;
    }
    private final int size;

    public int getSize(){ return size; }
}
