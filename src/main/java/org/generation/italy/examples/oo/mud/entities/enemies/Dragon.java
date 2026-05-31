package org.generation.italy.examples.oo.mud.entities.enemies;

import org.generation.italy.examples.oo.mud.Room;
import org.generation.italy.examples.oo.mud.Utils;
import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;

public class Dragon extends Enemy {
    private final int FIRE_BREATH_CHANCE = 40;
    private final int FIRE_DAMAGE = 25;

    public Dragon(String difficulty, Room startingRoom, int level) {
        super("Drago", 1, 15, 150, difficulty, startingRoom);
        this.setArmour(10);
        if (level > 1) this.levelUp(level - 1);
    }

    @Override
    public String attack(Entity target) throws InterruptedException {
        if (Utils.throwDice(getLuck()) <= FIRE_BREATH_CHANCE) return fireBreath(target);
        return super.attack(target);
    }
    public String fireBreath(Entity target) throws InterruptedException {
        IO.println(getName() + " spalanca le fauci e sputa una fiammata infernale su " + target.getName() + "!");
        Thread.sleep(500);

        int damage = FIRE_DAMAGE+getStrength();
        if (target.getShield() > 0) {
            damage -= (int)(target.getShield() * (Utils.throwDice(target.getLuck()) / 100.0));
        }

        // Forziamo il bypass dell'armatura aggiungendola temporaneamente al danno da infliggere
        target.getHit(damage + target.getArmour());
        return getName() + " ha bruciato " + target.getName() + " per " + damage + " danni puri!";
    }
    @Override
    public void die() {
        IO.println("Il maestoso " + getName() + " crolla a terra esanime, facendo tremare le pareti!");
        if (!loot.isEmpty()) {
            IO.println("Tra le sue scaglie dorate trovi: ");
            for (org.generation.italy.examples.oo.mud.Item i : loot) {
                getCurrentRoom().addItem(i);
                IO.println("- " + i.getName());
            }
        }
        setCurrentRoom(null);
    }
}
