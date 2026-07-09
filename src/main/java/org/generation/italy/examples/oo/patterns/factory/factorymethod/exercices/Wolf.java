package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Wolf implements Enemy{
    @Override
    public String name() {
        return "Wolf";
    }

    @Override
    public String habitat() {
        return "Forest";
    }
}
