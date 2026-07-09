package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public abstract class Level {

    public abstract Enemy createEnemy();
    public abstract Boss createBoss();
    public abstract Treasure createTreasure();
}
