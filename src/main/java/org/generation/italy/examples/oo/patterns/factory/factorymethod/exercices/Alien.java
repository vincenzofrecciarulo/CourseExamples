package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Alien implements Enemy{
    @Override
    public String knowYourName() {
        return "Alienix l'alieno";
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
