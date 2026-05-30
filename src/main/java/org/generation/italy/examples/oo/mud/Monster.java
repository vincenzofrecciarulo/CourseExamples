package org.generation.italy.examples.oo.mud;

public class Monster extends Entity {
    private final int attackPower;

    public Monster(int hp, String name, int level, int attackPower) {
        super(hp, name, level);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
