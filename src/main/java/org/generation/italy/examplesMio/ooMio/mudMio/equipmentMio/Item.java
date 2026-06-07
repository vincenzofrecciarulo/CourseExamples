package org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio;

public class Item {
    private String name;
    private int value;
    private double weight;
    private final int  id;
    private static int nextId = 1;

    public Item(double weight, int value, String name) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.id = nextId++;
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

    public int getId() {
        return id;
    }
}