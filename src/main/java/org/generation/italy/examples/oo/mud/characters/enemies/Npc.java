package org.generation.italy.examples.oo.mud.characters.enemies;

import org.generation.italy.examples.oo.mud.rpg.DndClass;
import org.generation.italy.examples.oo.mud.rpg.Race;
import org.generation.italy.examples.oo.mud.equipment.Weapon;
import org.generation.italy.examples.oo.mud.characters.Entity;

public class Npc extends Entity {

    public Npc(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon){
        super(currentHp, name, level, race, gender, dndClass, equippedWeapon);
    }

}
