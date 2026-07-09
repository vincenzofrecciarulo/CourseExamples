package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices.Enemy;

public class Wolf implements Enemy {
    @Override
    public String name() {
        return "Silver Fang";
    }

    @Override
    public String description() {
        return "WUUUUUUUUUUUUUF";
    }
}
