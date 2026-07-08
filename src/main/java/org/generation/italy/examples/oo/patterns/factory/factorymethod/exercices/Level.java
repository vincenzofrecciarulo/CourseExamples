package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public abstract class Level {
    public void play() {
        Enemy enemy = createEnemy();
        attack(enemy);
    }

    protected abstract Enemy createEnemy();

    private void attack(Enemy enemy) {
        IO.println("Attacking " + enemy.name() + " in the " + enemy.habitat());
    }
}