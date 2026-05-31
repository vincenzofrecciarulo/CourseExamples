package org.generation.italy.examples.oo.mud.characters.enemies;

import org.generation.italy.examples.oo.mud.rpg.Race;

public class Orc extends Monster {
    public Orc(String name, String gender){
        super(42, name, 3, Race.ORC, gender, 18);
    }
}
