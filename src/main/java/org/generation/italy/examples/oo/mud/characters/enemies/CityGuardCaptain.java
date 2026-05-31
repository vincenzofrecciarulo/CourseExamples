package org.generation.italy.examples.oo.mud.characters.enemies;

import org.generation.italy.examples.oo.mud.rpg.Race;
import org.generation.italy.examples.oo.mud.equipment.Weapon;
import org.generation.italy.examples.oo.mud.rpg.DndClass;

public class CityGuardCaptain extends HumanNpc {
    public CityGuardCaptain(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon) {
        super(38, name, 5, Race.HUMAN, gender, dndClass, equippedWeapon);
    }
}
