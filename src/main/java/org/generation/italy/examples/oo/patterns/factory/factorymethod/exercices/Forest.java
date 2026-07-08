package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Forest extends Level {
    @Override
    public void spawnEnemy() {
        this.enemy = new Wolf();
    }
}
