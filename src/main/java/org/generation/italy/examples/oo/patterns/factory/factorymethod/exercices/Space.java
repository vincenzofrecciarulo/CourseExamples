package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Space extends Level {
    @Override
    public void spawnEnemy() {
        this.enemy = new Alien();
    }
}
