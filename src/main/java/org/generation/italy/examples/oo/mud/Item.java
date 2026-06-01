package org.generation.italy.examples.oo.mud;

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

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
