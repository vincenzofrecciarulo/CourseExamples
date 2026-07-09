package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class SpaceFactory implements EnemyFactory{
    @Override
    public Soldier createSoldier() {
        return new Alien();
    }

    @Override
    public Boss createBoss() {
        return new AlienQueen();
    }

    @Override
    public Treasure createTreasure() {
        return new PowerCrystals();
    }
}
