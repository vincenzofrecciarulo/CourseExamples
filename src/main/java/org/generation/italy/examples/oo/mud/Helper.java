package org.generation.italy.examples.oo.mud;

import java.util.Random;

public class Helper {
    private static final Random random = new Random();

    public static int getRandomNumber(int length, int start){
        return random.nextInt(start, length);
    }

    public static int getRandomNumber(int length){
        return random.nextInt(length);
    }
}
