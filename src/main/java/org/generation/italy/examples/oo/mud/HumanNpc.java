package org.generation.italy.examples.oo.mud;

public class HumanNpc extends Npc{
    public HumanNpc(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon) {
        super(currentHp, name, level, race, gender, dndClass, equippedWeapon);
    }
}
