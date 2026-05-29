package org.generation.italy.examples.oo.mud;

public class Armor extends Item{
    private boolean isWeared;
    private int hp;

    public Armor(double weight, int value, String name, boolean isWeared) {
        super(weight, value, name);
        this.isWeared = isWeared;
        this.hp = hp;
    }
}
