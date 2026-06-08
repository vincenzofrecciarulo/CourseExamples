package org.generation.italy.examples.oo.mudPersonale.items;

import org.generation.italy.examples.oo.mudPersonale.entities.Player;

public abstract class Item {
    private final double weight;
    protected int price;
    private final String name;

    public Item(double weight, int price, String name) {
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public abstract void interact(Player player);

    public String getName() {
        return name;
    }

    public double getWeight(){
        return weight;
    }

    public int getPrice(){
        return price;
    }


}
