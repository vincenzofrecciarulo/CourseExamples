package org.generation.italy.examples.oo.battleShip;

public class Coordinate {
    char row;
    int column;

    public Coordinate(char row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return switch(this.row){
            case 'a'-> 0;
            case 'b'-> 1;
            case 'c'-> 2;
            case 'd'-> 3;
            case 'e'-> 4;
            case 'f'-> 5;
            case 'g'-> 6;
            case 'h'-> 7;
            case 'i'-> 8;
            case 'j'-> 9;
            default -> throw new IllegalStateException("Unexpected value: " + this.row);
        };
    }
    public int getColumn() {
        return column;
    }
}
