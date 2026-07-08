package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Enemy;

public interface MonsterFactory {
    Boss createBoss();
    Treasure createTreasure();
    Enemy createEnemy();
}
