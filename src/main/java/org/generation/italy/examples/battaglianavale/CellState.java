package org.generation.italy.examples.battaglianavale;

public enum CellState {
        HIT('X'), MISS('O'), EMPTY('~'), SHIP('S'), ALREADY_HIT('!');
        private final char symbol;

    CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

}
