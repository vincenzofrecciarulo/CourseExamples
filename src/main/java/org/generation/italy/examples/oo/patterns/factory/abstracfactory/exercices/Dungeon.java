package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class Dungeon extends Level{
    @Override
    public Enemy createEnemy() {
        return new Goblin();
    }

    @Override
    public Boss createBoss() {
        return new Necromancer();
    }

    @Override
    public Treasure createTreasure() {
        return new MagicMushroom();
    }
}
