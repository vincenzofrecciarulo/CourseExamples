package org.generation.italy.examples.oo.mud;

import java.util.Random;

public class DiceRoller {
    Random r = new Random();

    public int rollD20(){
        return r.nextInt(20) + 1;
    }

    public int rollD6() {
        return r.nextInt(6) + 1;
    }
}
