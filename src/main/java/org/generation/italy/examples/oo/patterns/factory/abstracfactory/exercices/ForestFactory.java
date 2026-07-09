package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class ForestFactory implements EnemyFactory{
    @Override
    public Soldier createSoldier() {
        return new Wolf();
    }

    @Override
    public Boss createBoss() {
        return new SpeakingTree();
    }

    @Override
    public Treasure createTreasure() {
        return new MagicMushroom();
    }
}
