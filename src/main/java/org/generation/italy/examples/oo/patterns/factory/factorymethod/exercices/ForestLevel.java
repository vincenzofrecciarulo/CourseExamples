package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class ForestLevel extends Level {

    @Override
    protected Enemy create() {
        return new Wolf();
    }
}