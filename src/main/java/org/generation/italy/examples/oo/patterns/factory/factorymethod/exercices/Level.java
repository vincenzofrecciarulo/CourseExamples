package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public abstract class Level {

    public abstract Enemy createEnemy();
    public void attackEnemy(Enemy e) {
        System.out.println("Hai attaccato"+ e.knowYourName());
    }
}
