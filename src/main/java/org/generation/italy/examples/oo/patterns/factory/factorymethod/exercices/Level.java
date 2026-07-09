package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public abstract class Level {
    public Enemy createEnemy() {
        Enemy enemy = create();
        finded(enemy);
        return enemy;
    }

    protected abstract Enemy create();

    private void finded(Enemy enemy){
        IO.println("Found " + enemy.name());
    }
}
