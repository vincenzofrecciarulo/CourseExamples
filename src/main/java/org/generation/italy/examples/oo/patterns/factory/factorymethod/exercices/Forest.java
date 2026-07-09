package org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices;

import static org.generation.italy.examples.oo.patterns.factory.factorymethod.exercices.EnemyType.WOLF;

public class Forest extends Level{
    @Override
    protected Enemy createEnemy(EnemyType type) {
        return new Wolf();
        };
    }
}
