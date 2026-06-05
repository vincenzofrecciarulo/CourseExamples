package org.generation.italy.examples.oo.mudPersonale.entities;

public abstract class Entity {
    private final String name;


    public Entity(String name) {
        this.name = name;
    }


    public abstract void interact(Player player);

    public String getName() {
        return name;
    }

}
