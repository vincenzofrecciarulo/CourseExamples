package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public interface LevelFactory {
    Enemy createEnemy();
    Boss createBoss();
    Treasure createTreasure();
}