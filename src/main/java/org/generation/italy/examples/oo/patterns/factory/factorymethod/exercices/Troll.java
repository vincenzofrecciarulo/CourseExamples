package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Troll implements Enemy{
    @Override
    public String knowYourName() {
        return "Giggi il troll";
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
