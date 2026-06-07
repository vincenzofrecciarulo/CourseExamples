package org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies;

import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.DndClass;
import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Race;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Weapon;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.Entity;

public class Npc extends Entity {

    public Npc(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon){
        super(currentHp, name, level, race, gender, dndClass, equippedWeapon);
    }

}
