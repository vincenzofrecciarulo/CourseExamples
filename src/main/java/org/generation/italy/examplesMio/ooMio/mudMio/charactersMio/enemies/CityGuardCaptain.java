package org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies;

import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Race;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Weapon;
import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.DndClass;

public class CityGuardCaptain extends HumanNpc {
    public CityGuardCaptain(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon) {
        super(38, name, 5, Race.HUMAN, gender, dndClass, equippedWeapon);
    }
}
