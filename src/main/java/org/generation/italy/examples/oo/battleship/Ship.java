package org.generation.italy.examples.oo.battleship;

public class Ship {
    private final int size;
    private Orientation orientation;
    private int coordinationX; // riga
    private int coordinationY; // colonna

    public Ship(int size) {
        this.size = size;
    }

    public Ship(int size, Orientation orientation, int coordinationX, int coordinationY) {
        this.size = size;
        this.orientation = orientation;
        this.coordinationX = coordinationX;
        this.coordinationY = coordinationY;
    }

    public int getSize() {
        return size;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getCoordinationX() {
        return coordinationX;
    }

    public int getCoordinationY() {
        return coordinationY;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setCoordinationX(int coordinationX) {
        this.coordinationX = coordinationX;
    }

    public void setCoordinationY(int coordinationY) {
        this.coordinationY = coordinationY;
    }
}
