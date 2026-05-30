package org.generation.italy.examples.oo.mud;

public class Item {
    private String name;
    private int value;
    private double weight;

    public Item(double weight, int value, String name) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }


}
