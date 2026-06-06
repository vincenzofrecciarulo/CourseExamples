package org.generation.italy.examples.oo.mud;

import java.util.List;

public abstract class Entity {
    protected String name;
    protected int hp;
    protected List<Item> items;
    protected int damage;
    protected Room currentRoom;



    public Entity(String name, int hp, List<Item> items, int damage) {
        this.name = name;
        this.hp = hp;
        this.items = items;
        this.damage = damage;

    }

    public Entity(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;

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


