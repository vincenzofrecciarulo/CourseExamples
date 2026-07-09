package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class SpaceLevel extends Level {

    @Override
    protected Enemy create() {
        return new Alien();
    }
}
