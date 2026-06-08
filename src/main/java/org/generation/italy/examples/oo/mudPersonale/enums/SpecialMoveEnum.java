package org.generation.italy.examples.oo.mudPersonale.enums;

public enum SpecialMoveEnum {
    THUNDERBOLT("Thunderbolt", 80),
    POUND("Pound", 40);

    SpecialMoveEnum(String name, int power) {
        this.name = name;
        this.power = power;
    }

    private final String name;
    private final int power;

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }
}
