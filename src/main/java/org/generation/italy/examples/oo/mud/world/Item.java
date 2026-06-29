package org.generation.italy.examples.oo.mud.world;

public class Item {
    private static int nextId = 1;
    private final int id;
    private double weight;
    private int value;
    private String name;

    public Item(double weight, int value, String name) {
        this.id = nextId++;
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
