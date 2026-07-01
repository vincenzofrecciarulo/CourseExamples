package org.generation.italy.examples.oo.abstractedmud.dynamics;

import org.generation.italy.examples.oo.abstractedmud.entities.Entity;

public interface Fighter{
    int  attack(Fighter enemy);
    int takeDamage(int damage);
    boolean dodgeAttack();
}
