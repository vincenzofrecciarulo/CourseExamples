package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Space extends Level {
    @Override
    protected Enemy createEnemy() {
        return new Alien();
    }
}