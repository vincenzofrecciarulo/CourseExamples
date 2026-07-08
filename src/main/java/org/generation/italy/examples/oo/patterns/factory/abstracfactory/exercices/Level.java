package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Enemy;

public abstract class Level implements MonsterFactory{

    public void enemyAttack(){
        Enemy enemy = createEnemy();
        enemy.attack();
    }

    public void bossSpecialAttack(){
        Boss boss = createBoss();
        boss.specialAttack();
    }

    public void treasureGather(){
        Treasure treasure = createTreasure();
        treasure.gather();
    }
}
