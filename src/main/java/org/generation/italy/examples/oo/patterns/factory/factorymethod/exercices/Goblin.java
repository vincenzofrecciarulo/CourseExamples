package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Goblin implements Enemy{
    @Override
    public String name() {
        return "Michele";
    }

    @Override
    public String description() {
        return "Sono un goblin carino!";
    }
}
