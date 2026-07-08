package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public  interface EntityFactory {
    Entity createEnemy();
    Boss createBoss();
    Treasure createTreasure();
}
