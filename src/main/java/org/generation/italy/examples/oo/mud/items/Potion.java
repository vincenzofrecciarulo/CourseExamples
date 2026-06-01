package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.Utils;
import org.generation.italy.examples.oo.mud.entities.Player;

public class Potion extends Item {
    private int healAmount;

    public Potion(String name, int healAmount, double value) {
        super(name, value, 0.5, true);
        this.healAmount = healAmount;
        this.type = 'p';
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public String use(Player player) {
        int realHealing=(int)(healAmount*(Utils.throwDice(player.getLuck())/100.0));
        player.heal(realHealing);
        player.removeFromInventory(this);
        return "Hai bevuto " + this.getName() + " e rigenerato fino a " + realHealing + " HP! L'ampolla si rompe.";
    }
}
