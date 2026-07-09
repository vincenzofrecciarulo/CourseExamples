package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class DungeonFactory implements EnemyFactory{
    @Override
    public Soldier createSoldier() {
        return new Goblin();
    }

    @Override
    public Boss createBoss() {
        return new GoblinKing();
    }

    @Override
    public Treasure createTreasure() {
        return new GoldBar();
    }
}
