package org.generation.italy.examples.oo.mudPersonale.items;

import org.generation.italy.examples.oo.mudPersonale.entities.Player;

public class Item {
    private final double weight;
    protected int value;
    private final String name;

    public Item(double weight, int value, String name) {
        this.weight = weight;
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public void interact(Player player){

    }
}
