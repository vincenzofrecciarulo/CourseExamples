package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Enemy;
import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Goblin;


public class DungeonFactory extends Level{
    @Override
    public Boss createBoss() {
        return new Necromancer();
    }

    @Override
    public Treasure createTreasure() {
        return new MagicCoin();
    }

    @Override
    public Enemy createEnemy() {
        return new Goblin();
    }
}
