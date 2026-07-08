package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class SpaceLevelFactory implements LevelFactory {
    @Override
    public Enemy createEnemy() {
        return new AlienSoldier();
    }

    @Override
    public Boss createBoss() {
        return new AlienQueen();
    }

    @Override
    public Treasure createTreasure() {
        return new AntimatterCrystal();
    }
}