package org.generation.italy.examples.oo.mud;

public interface Fightable {
    int attack();
    int takeDamage(int incomingDamage);
    boolean isAlive();
    String getName();
    int getExpReward();
    int getGoldReward();
    int getCurrentHp();
}