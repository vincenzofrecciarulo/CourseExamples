package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Alien implements Enemy{
    @Override
    public String name() {
        return "Alien";
    }

    @Override
    public String habitat() {
        return "Space";
    }
}
