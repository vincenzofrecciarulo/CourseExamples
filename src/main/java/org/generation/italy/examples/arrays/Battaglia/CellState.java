package org.generation.italy.examples.arrays.Battaglia;

public enum CellState {
        HIT('X'), MISS('O'), EMPTY('~'), SHIP('S');
        private final char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

}
