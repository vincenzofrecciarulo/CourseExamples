package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

import java.util.List;

public abstract class Level {
    Enemy enemy;
    public void attackEnemy(){
        enemy.getHit();
    };
    public void talkToEnemy(){
        enemy.speak();
    }
    public abstract void spawnEnemy();


}
