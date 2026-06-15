package org.generation.italy.examples.oo.battleship;

public class Coordinate {
    private char column;
    private int row;

    public Coordinate(char column, int row) {
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
    public static Coordinate getCoordinate(String input){
        String[] ar = input.split(",");
        char cl = ar[0].charAt(0);
        int rw =Integer.parseInt(ar[1]);
        return new Coordinate(cl,rw);
    }
}
