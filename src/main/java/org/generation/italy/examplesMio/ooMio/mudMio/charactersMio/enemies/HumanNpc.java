package org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies;

import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.DndClass;
import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Race;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Weapon;

public class HumanNpc extends Npc {
    public HumanNpc(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon) {
        super(currentHp, name, level, race, gender, dndClass, equippedWeapon);
    }
}
