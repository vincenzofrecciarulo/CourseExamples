package org.generation.italy.examples.oo.navalbattle.enums;

public enum Direction {
    NORTH,SOUTH,EAST,WEST;

    public static Direction getDirection(Character c) throws Exception {
        return switch (c) {
            case 'n' -> NORTH;
            case 's' -> SOUTH;
            case 'e' -> EAST;
            case 'o' -> WEST;
            default -> throw new Exception();
        };
    }
}
