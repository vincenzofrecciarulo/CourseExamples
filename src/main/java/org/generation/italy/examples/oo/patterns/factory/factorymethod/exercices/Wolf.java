package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Wolf implements Enemy {

    @Override
    public void getHit() {
        IO.println("Il lupo è stato colpito!");
    }

    @Override
    public void speak() {
        IO.println("Il lupo dice: 'Auuu!'");
    }
}
