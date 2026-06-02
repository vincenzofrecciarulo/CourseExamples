package org.generation.italy.examples.oo.mud;

public class Entity {
    private int hp;
    private String name;
    private int level;
    private int attack;
    private int defense;
    private boolean hostile;

    public Entity(int hp, String name, int level, int attack, int defense, boolean hostile) {
        this.hp = hp;
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.hostile = hostile;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isHostile() {
        return hostile;
    }
    public void takeDamage(int damage){
        this.hp -= damage;
        if (this.hp < 0){
            this.hp = 0;
        }
    }
}
