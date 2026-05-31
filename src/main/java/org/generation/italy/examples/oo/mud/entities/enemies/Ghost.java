package org.generation.italy.examples.oo.mud.entities.enemies;

import org.generation.italy.examples.oo.mud.Item;
import org.generation.italy.examples.oo.mud.Room;
import org.generation.italy.examples.oo.mud.Utils;
import org.generation.italy.examples.oo.mud.entities.Entity;

public class Ghost extends Enemy {
    private final int PASS_THROUGH_CHANCE = 50;
    private final int HORRIFY_CHANCE = 30;

    public Ghost(String difficulty, Room startingRoom, int level) {
        super("Spettro", 1, 5, 40, difficulty, startingRoom);
        if (level > 1) this.levelUp(level - 1);
    }

    @Override
    public int getHit(int damage) {
        if (Utils.throwDice(0) <= PASS_THROUGH_CHANCE) {
            IO.println("Il colpo attraversa il corpo fumoso dello " + getName() + " senza fargli nulla!");
            return 0;
        }
        return super.getHit(damage);
    }

    @Override
    public String attack(Entity target) throws InterruptedException {
        String msg = super.attack(target);

        if (Utils.throwDice(getLuck()) > (100 - HORRIFY_CHANCE)) {
            IO.println("Lo " + getName() + " lancia un urlo agghiacciante che gela il sangue nelle vene di "
                    + target.getName() + "!");
            Thread.sleep(300);
            IO.println("Il terrore paralizza " + target.getName() + ": la sua determinazione vacilla!");
        }
        return msg;
    }

    @Override
    public void die() {
        IO.println("Lo " + getName() + " svanisce nell'aria lasciando dietro di sé un brivido freddo...");
        if (!loot.isEmpty()) {
            IO.println("Sul pavimento, dove fluttuava lo spettro, appaiono: ");
            for (Item i : loot) {
                getCurrentRoom().addItem(i);
                IO.println("- " + i.getName());
            }
        }
        setCurrentRoom(null);
    }
}
