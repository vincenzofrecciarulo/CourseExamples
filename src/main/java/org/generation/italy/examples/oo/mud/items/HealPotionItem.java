package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.entities.Player;

public class HealPotionItem extends Item{
    private static final String NAME = "Heal potion";
    private static final int VALUE = 50;
    public static final double WEIGHT = 15.0;

    public HealPotionItem() {
        super(HealPotionItem.WEIGHT, HealPotionItem.VALUE, HealPotionItem.NAME);
    }

    @Override
    public void interact(Player player){
        player.heal(value);
        player.drop(this);
        System.out.println("Hai recuperato " + VALUE + " vita");
    }
}
