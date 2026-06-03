package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Enemy extends Entity{
    private int damage;
    private Item weapon;
    private Inventory deathLoot;

    public Enemy(int hp,String name,int level,Item weapon,int damage,Inventory deathLoot){
        super(name,hp, level);
        this.weapon=weapon;
        this.damage=damage;
        this.deathLoot=deathLoot;
    }
    public Item getWeapon(){
        return weapon;
    }
    public int getDamage(){
        return damage;
    }
    public Inventory getDeathLoot(){
        return deathLoot;
    }



}
