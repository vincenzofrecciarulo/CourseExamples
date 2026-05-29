package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.entities.Player;

public class HealPotion extends Item{
    private static final String NAME = "Heal potion";
    private static final int VALUE = 50;
    private static final double WEIGHT = 15.0;

    public HealPotion() {
        super(HealPotion.WEIGHT, HealPotion.VALUE, HealPotion.NAME);
    }

    @Override
    public void interact(Player player){

    }
}
