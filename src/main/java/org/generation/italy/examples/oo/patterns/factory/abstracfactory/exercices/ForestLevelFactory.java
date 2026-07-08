package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class ForestLevelFactory implements LevelFactory {
    @Override
    public Enemy createEnemy() {
        return new Wolf();
    }

    @Override
    public Boss createBoss() {
        return new Troll();
    }

    @Override
    public Treasure createTreasure() {
        return new MagicMushroom();
    }
}