package org.generation.italy.examples.oo.mud.equipment;

public class Potion extends Item {
    private int healAmount;

    public Potion(double weight, int value, String name, int healAmount){
        super(weight, value, name);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
