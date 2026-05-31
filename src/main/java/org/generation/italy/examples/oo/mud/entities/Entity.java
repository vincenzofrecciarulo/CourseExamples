package org.generation.italy.examples.oo.mud.entities;

public class Entity {
    protected int hp;
    private String name;
    private int level;


    public Entity(int hp, String name, int level) {
        this.hp = hp;
        this.name = name;
        this.level = level;
    }


    public void interact(Player player){

    }

    public String getName() {
        return name;
    }

    public int getHp(){
        return hp;
    }

    public int getLevel(){
        return level;
    }


}
