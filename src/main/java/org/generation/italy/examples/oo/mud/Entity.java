package org.generation.italy.examples.oo.mud;

public class Entity {
    private int hp;
    private String name;
    private int level;

    public Entity(){};

    public Entity(String name, int hp, int level){
        this.name = name;
        this.hp = hp;
        this.level = level;
    }

    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    public int level(){
        return level;
    }
}
