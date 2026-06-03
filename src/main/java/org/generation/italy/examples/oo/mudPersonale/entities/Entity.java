package org.generation.italy.examples.oo.mudPersonale.entities;

public class Entity {
    private final String name;


    public Entity(String name) {
        this.name = name;
    }


    public void interact(Player player){
        IO.println(name + " si gratta il culo");
    }

    public String getName() {
        return name;
    }

}
