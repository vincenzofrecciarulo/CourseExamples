package org.generation.italy.examples.oo.mud.characters.enemies;

import org.generation.italy.examples.oo.mud.rpg.Race;

public class Goblin extends Monster {
    public Goblin(String name, String gender){
        super(16, name, 3, Race.GOBLIN, gender, 6);
    }
}
