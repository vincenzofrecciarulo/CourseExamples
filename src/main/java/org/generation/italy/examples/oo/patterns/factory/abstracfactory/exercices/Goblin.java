package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices.Enemy;

public class Goblin implements Enemy {
    @Override
    public String name() {
        return "Michele";
    }

    @Override
    public String description() {
        return "Sono un goblin carino!";
    }
}
