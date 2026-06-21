package org.generation.italy.examples.oo.navalbattle.enums;

public enum BoatSize {
    SMALL(1), MEDIUM(2), LARGE(4);

    private final int boatLength;

    BoatSize(int boatLength){
        this.boatLength = boatLength;
    }

    public int getBoatLength(){
        return boatLength;
    }

    public static BoatSize getBoatSize(int length) throws Exception {
        return switch (length) {
            case 1 -> SMALL;
            case 2 -> MEDIUM;
            case 4 -> LARGE;
            default -> throw new Exception();
        };
    }
}
