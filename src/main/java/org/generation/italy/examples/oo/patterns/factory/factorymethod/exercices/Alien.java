package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Alien implements Enemy {
    @Override
    public void getHit() {
        IO.println("L'alieno £$$*_// è stato colpito");
    }
    @Override
    public void speak() {
        IO.println("L'alieno dice: 'Z$$%%%£");
    }
}
