package org.generation.italy.examples.oo.mud;

public class Item {
    private double weight;
    private int value;    // value in gold
    private String name;

    public Item(double weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
