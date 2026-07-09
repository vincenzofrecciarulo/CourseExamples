package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Dungeon extends Level{
    @Override
    public Enemy createEnemy() {
        return new Troll();
    }
}
