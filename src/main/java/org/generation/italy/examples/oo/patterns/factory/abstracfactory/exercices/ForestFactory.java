package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;
import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Enemy;
import org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.Wolf;

public class ForestFactory extends Level {
    @Override
    public Boss createBoss() {
        return new Troll();
    }

    @Override
    public Treasure createTreasure() {
        return new MagicMushroom();
    }

    @Override
    public Enemy createEnemy() {
        return new Wolf();
    }
}
