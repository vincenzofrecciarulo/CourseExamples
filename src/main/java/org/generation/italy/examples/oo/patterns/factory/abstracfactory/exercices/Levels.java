package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class Levels {
    private final Soldier soldier;
    private final Boss boss;
    private final Treasure treasure;

    public Levels(EnemyFactory enemyFactory) {
        soldier = enemyFactory.createSoldier();
        boss = enemyFactory.createBoss();
        treasure = enemyFactory.createTreasure();
    }

    public String describe() {
        return soldier.name() + " + " + boss.name() + " + " + treasure.name();
    }

    public Boss getBoss() {
        return boss;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public Treasure getTreasure() {
        return treasure;
    }
}
