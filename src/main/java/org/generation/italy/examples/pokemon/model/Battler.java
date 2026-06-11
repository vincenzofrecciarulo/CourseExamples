package org.generation.italy.examples.pokemon.model;

import java.util.List;

public interface Battler {
    String getName();
    int getLevel();
    int getCurrentHp();
    int getMaxHp();
    boolean isAlive();
    List<Move> getMoves();
    PokemonType[] getTypes();
    StatusEffect getStatus();
    void setStatus(StatusEffect effect);
    void takeDamage(int damage);
    int getAttack();
    int getDefense();
    int getSpAttack();
    int getSpDefense();
    int getSpeed();
}