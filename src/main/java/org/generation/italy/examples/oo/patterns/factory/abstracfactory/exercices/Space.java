package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class Space extends Level{
    @Override
    public Enemy createEnemy() {
        return new Alien();
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
