package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.Room;
import org.generation.italy.examples.oo.mud.Utils;

public class Entity {
    private int hp;
    private String name="";
    private int level;
    private int strength;
    private int luck;
    private Room currentRoom;
    private int armour=0;
    private int shield=0;
    public Entity(String name,int level,int strength,int hp,Room startingRoom){
        this.name=name;
        this.level=level;
        this.strength=strength;
        this.hp=hp;
        this.currentRoom=startingRoom;

    }
    public int levelUp(int levels){
        level+=levels;
        int newStrength=0;
        for (int i = 0; i < levels; i++) {
            newStrength+= (int) (strength*(15/100.0));
        }
        return level;
    }
    public boolean moveTo(String direction){
        boolean moved=false;
        Room destination= currentRoom.getExitAt(direction);
        if(destination==null) return moved;
        this.setCurrentRoom(destination);
        moved=true;
        return moved;

    }
    public String attack(Entity target) throws InterruptedException {
        int strength=getStrength();
        StringBuilder sb= new StringBuilder();
        IO.println(getName()+" Prova ad attaccare "+target.getName());
        Thread.sleep(300);
        int damage= Utils.throwDice(getLuck())+strength;
        int hit=target.getHit(damage);
        if(hit>0)   return getName()+" Ha colpito "+target.getName();
        else        return target.getName()+" Non ha subito danno";
    }
    public int getHit(int damage){
        damage-=this.armour;
        damage-=(int)(this.shield*(Utils.throwDice(this.luck)/100.0));
        if(damage>0){
            this.hp-=damage;
            if(this.hp<=0)  this.die();
        }else   IO.println(getName()+ "PARA IL COLPO");
        return damage;
    }
    public void die(){
        IO.println(getName()+" E' MORTO");
        this.setCurrentRoom(null);
    }

    public void setCurrentRoom(Room destination){
        this.currentRoom=destination;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
    public void setShield(int shield){
        this.shield=shield;
    }

    public void setLuck(int luck) {
        this.luck = luck;
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
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public int getStrength() {
        return strength;
    }

    public int getLuck() {
        return luck;
    }
    public int getArmour(){
        return armour;
    }

    public int getShield() {
        return shield;
    }
}
