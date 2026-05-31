package org.generation.italy.examples.oo.mud.characters.enemies;

import org.generation.italy.examples.oo.mud.rpg.DndClass;
import org.generation.italy.examples.oo.mud.rpg.Race;
import org.generation.italy.examples.oo.mud.equipment.Weapon;

public class HumanNpc extends Npc {
    public HumanNpc(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon) {
        super(currentHp, name, level, race, gender, dndClass, equippedWeapon);
    }
}
