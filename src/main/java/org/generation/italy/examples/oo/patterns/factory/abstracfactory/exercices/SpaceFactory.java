package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Alien;
import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Enemy;

public class SpaceFactory extends Level{
    @Override
    public Boss createBoss() {
        return new AlienQueen();
    }

    @Override
    public Treasure createTreasure() {
        return new AntimatterCrystal();
    }

    @Override
    public Enemy createEnemy() {
        return new Alien();
    }
}
