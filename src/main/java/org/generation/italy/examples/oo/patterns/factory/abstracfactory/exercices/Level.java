package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class Level {
    private final Enemy enemy;
    private final Boss boss;
    private final Treasure treasure;

    public Level(LevelFactory levelFactory) {
        enemy = levelFactory.createEnemy();
        boss = levelFactory.createBoss();
        treasure = levelFactory.createTreasure();
    }

    public String describe() {
        return enemy.name() + " + " + boss.name() + " + " + treasure.name();
    }

    public Enemy getEnemy() { return enemy; }
    public Boss getBoss() { return boss; }
    public Treasure getTreasure() { return treasure; }
}