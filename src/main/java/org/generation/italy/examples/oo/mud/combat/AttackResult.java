package org.generation.italy.examples.oo.mud.combat;

public class AttackResult {
    private final boolean hit;
    private final int attackRoll;
    private final int defenseRoll;
    private final int damage;

    public AttackResult(boolean hit, int attackRoll, int defenseRoll, int damage) {
        this.hit = hit;
        this.attackRoll = attackRoll;
        this.defenseRoll = defenseRoll;
        this.damage = damage;
    }

    public boolean isHit() {
        return hit;
    }

    public int getAttackRoll() {
        return attackRoll;
    }

    public int getDefenseRoll() {
        return defenseRoll;
    }

    public int getDamage() {
        return damage;
    }
}
