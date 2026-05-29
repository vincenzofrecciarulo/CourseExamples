package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.Random;

public class Entity {
    private int hp;
    private String name="";
    private int level;
    private int strength;
    private Random luck=new Random();

    public Entity(String name,int level,int strength,int hp){
        this.name=name;
        this.level=level;
        this.strength=strength;
        this.hp=hp;
    }
    public int throw(int extra){
        return luck.nextInt(extra,100);
    }
    public int levelUp(int levels){
        level+=levels;
        return level;
    }
    public int getHp() {
        return hp;
    }
    public String getName() {
        return name;
    }
    public int getLevel(){
        return level;
    }
}
