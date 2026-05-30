package org.generation.italy.examples.oo.mud;

import java.util.Random;

public class RandomDiceRoller implements DiceRoller {
    private final Random random;

    public RandomDiceRoller(Random random) {
        this.random = random;
    }

    @Override
    public int rollD21() {
        return random.nextInt(21) + 1;
    }
}
