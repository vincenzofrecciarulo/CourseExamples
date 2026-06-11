package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected String name;
    protected int hp;
    protected List<Item> items;
    protected  String text;
    protected int damage;
    protected Room currentRoom;



    public Entity(String name, int hp, List<Item> items,String text, int damage) {
        this.name = name;
        this.hp = hp;
        this.items = items;
        this.damage = damage;
        this.text=text;

    }

    public Entity(String name, int hp,String text, int damage) {
        this.name = name;
        this.hp = hp;
        this.text=text;
        this.damage = damage;
        this.items = new ArrayList<>();

    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean takeDamage(int damage) {
        hp -= damage;
        return isAlive();
    }

    public boolean attack(Entity target) {
        return target.takeDamage(damage);
    }


    public boolean isAlive() {
        return hp > 0;
    }

    public abstract void onDeath();

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}


