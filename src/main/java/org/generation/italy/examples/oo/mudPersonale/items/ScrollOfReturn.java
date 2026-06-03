package org.generation.italy.examples.oo.mudPersonale.items;

import org.generation.italy.examples.oo.mudPersonale.entities.Player;

public class ScrollOfReturn extends Item {
    private static final String NAME = "Scroll of return";
    private static final int VALUE = 0;
    public static final double WEIGHT = 5.0;

    public ScrollOfReturn() {
        super(ScrollOfReturn.WEIGHT, ScrollOfReturn.VALUE, ScrollOfReturn.NAME);
    }

    @Override
    public void interact(Player player){
        System.out.println("Inizio teletrasporto!");
        player.teleportToStart();
        player.drop(this);
    }
}
