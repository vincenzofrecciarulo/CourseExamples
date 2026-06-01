package org.generation.italy.examples.oo.mud.entities.pokemon;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.enums.Nature;

import java.util.Random;

public class Pokemon extends Entity {
    public Nature nature;
    public Pokemon(int hp, String name, int level) {
        super(hp, name, level);
    }

    public Nature getRandomNature(){
        int randomNum = new Random().nextInt(Nature.values().length);
        return Nature.values()[randomNum];
    }
}
