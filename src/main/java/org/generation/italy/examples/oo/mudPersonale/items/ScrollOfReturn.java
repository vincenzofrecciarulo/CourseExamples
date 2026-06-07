package org.generation.italy.examples.oo.mudPersonale.items;

import org.generation.italy.examples.oo.mudPersonale.entities.Player;

public class ScrollOfReturn extends Item {
    public static final String NAME = "Scroll of return";
    public static final int PRICE = 5;
    public static final double WEIGHT = 5.0;

    public ScrollOfReturn() {
        super(ScrollOfReturn.WEIGHT, ScrollOfReturn.PRICE, ScrollOfReturn.NAME);
    }

    @Override
    public void interact(Player player){
        System.out.println("Inizio teletrasporto!");
        player.teleportToStart();
        player.drop(this);
    }
}
