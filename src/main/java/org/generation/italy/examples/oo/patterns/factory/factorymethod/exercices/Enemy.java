package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;


public abstract class Enemy {
    protected EnemyType type;
    protected Level location;

    public Enemy(EnemyType type, Level location) {
        this.type = type;
        this.location = location;
    }
}
