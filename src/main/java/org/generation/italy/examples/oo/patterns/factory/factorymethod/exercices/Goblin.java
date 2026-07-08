package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Goblin implements Enemy {
    @Override
    public void getHit() {
        IO.println("Il goblin è stato colpito");
    }

    @Override
    public void speak() {
        IO.println("Il goblin dice: 'Grrr!'");
    }
}
