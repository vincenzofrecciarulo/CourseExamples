package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class Goblin implements Enemy {
    @Override
    public String name() {
        return "Goblin";
    }

    @Override
    public String habitat() {
        return "dungeon";
    }
}