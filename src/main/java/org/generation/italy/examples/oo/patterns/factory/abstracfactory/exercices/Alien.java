package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices.Enemy;

public class Alien implements Enemy {
    @Override
    public String name() {
        return "E.T";
    }

    @Override
    public String description() {
        return "Ti squaglio il cervello per poi berlo!";
    }
}
