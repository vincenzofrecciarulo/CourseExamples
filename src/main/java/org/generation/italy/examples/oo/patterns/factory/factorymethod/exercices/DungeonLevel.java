package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

public class DungeonLevel extends Level {

    @Override
    protected Enemy create() {
        return new Goblin();
    }
}
