package org.generation.italy.examples.pokemon.model;

public abstract class Item {
    protected final String name;
    protected final String description;
    protected final int buyPrice;

    protected Item(String name, String description, int buyPrice) {
        this.name = name;
        this.description = description;
        this.buyPrice = buyPrice;
    }

    /** Use this item on the given Pokémon. Returns true if the item was consumed. */
    public abstract boolean use(Pokemon pokemon);

    public String getName()       { return name; }
    public String getDescription(){ return description; }
    public int getBuyPrice()      { return buyPrice; }

    @Override
    public String toString() {
        return String.format("%-14s - %s  (%d coins)", name, description, buyPrice);
    }
}