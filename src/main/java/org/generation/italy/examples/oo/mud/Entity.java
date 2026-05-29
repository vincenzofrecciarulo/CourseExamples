package org.generation.italy.examples.oo.mud;

public class Entity {
    private int hp;
    private String name;
    private int level;

    public Entity(int hp, String name, int level) {
        this.hp = hp;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
