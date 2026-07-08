package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class Wolf implements Enemy {

    @Override
    public String name() {
        return "wolf";
    }

    @Override
    public void speak() {
        IO.println("Il lupo dice: 'Auuu!'");
    }

    @Override
    public void attack() {
        IO.println("Il lupo attacca con un morso!");
    }
}

