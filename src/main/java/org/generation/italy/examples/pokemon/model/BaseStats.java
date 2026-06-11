package org.generation.italy.examples.pokemon.model;

public class BaseStats {
    private final int hp, attack, defense, spAttack, spDefense, speed;

    public BaseStats(int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
    }

    public int getHp()        { return hp; }
    public int getAttack()    { return attack; }
    public int getDefense()   { return defense; }
    public int getSpAttack()  { return spAttack; }
    public int getSpDefense() { return spDefense; }
    public int getSpeed()     { return speed; }
}