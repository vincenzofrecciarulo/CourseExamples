package org.generation.italy.examples.oo.mud.items;

public class Item {
    private double weight;
    private int value;
    private String name;

    public Item(double weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
