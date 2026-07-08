package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Dungeon extends Level {
    @Override
    protected Enemy createEnemy() {
        return new Goblin();
    }
}