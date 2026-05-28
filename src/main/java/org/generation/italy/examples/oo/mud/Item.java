package org.generation.italy.examples.oo.mud;

public class Item {
    private String name;
    private double weight;
    private int value;

    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }
}
