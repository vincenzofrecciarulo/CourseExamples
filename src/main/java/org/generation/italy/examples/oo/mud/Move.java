package org.generation.italy.examples.oo.mud;

public class Move {

    private final String name;
    private int damage;
    private String description;

    public Move(String name, int damage, String description){
        this.name=name;
        this.damage=damage;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getDescription() {
        return description;
    }

}
