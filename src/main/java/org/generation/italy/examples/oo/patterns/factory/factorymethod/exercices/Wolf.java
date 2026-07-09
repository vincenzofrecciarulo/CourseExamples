package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Wolf implements Enemy{
    @Override
    public String knowYourName() {
        return "Lupo Lucio";
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
