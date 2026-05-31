package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.World;
import org.generation.italy.examples.oo.mud.entities.Player;

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
        World.map.resetToStart();
        player.drop(this);
    }
}
