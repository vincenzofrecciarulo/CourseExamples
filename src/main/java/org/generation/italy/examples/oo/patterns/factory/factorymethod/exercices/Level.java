package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public abstract class Level {
    public abstract Enemy createEnemy();

    public void enemyAttack(){
        Enemy enemy1 = createEnemy();
        enemy1.attack();
    }
}
