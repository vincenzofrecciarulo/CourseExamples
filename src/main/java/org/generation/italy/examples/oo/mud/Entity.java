package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.roles.CharacterStats;

public abstract class Entity {
    private static int nextId = 1;
    private final int id;
    private int hp;
    private String name;
    private int level;

    protected Entity(int hp, String name, int level) {
        this.id = nextId++;
        this.hp = hp;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public abstract CharacterStats getStats();

    public int getAttackBonus() {
        return 0;
    }

    public int getDefenseBonus() {
        return 0;
    }

    public int getDamageBonus() {
        return 0;
    }

    /**
     * Apply damage to this entity and return true if it died (hp <= 0).
     */
    public boolean applyDamage(int dmg) {
        this.hp -= dmg;
        return this.hp <= 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return String.format("%s (lvl %d, hp %d)", name, level, hp);
    }
}
