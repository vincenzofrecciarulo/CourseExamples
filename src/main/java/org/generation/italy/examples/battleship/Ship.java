package org.generation.italy.examples.battleship;

public class Ship {

    private final int dimension;
    private int[] rows;
    private int[] columns;
    private Direction direction;

    public Ship(int dimension, int[] rows, int[] columns, Direction direction){
        this(dimension);
        this.rows=rows;
        this.columns=columns;
        this.direction=direction;
    }

    public Ship(int dimension){
        this.dimension=dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public int[] getRows() {
        return rows;
    }

    public void setRows(int[] rows) {
        this.rows = rows;
    }

    public int[] getColumns() {
        return columns;
    }

    public void setColumns(int[] columns) {
        this.columns = columns;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
