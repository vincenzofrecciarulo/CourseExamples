package org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies;

import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Race;

public class Monster extends Npc {
    private int attackDmg;

    public Monster(int currentHp, String name, int level, Race race, String gender, int attackDmg) {
        super(currentHp, name, level, race, gender, null, null);
        this.attackDmg = attackDmg;
    }

    public int getAttackDmg() {
        return attackDmg;
    }
}
