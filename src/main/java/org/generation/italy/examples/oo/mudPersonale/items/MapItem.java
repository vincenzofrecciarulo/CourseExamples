package org.generation.italy.examples.oo.mudPersonale.items;

import org.generation.italy.examples.oo.mudPersonale.World;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;

public class MapItem extends Item{
    public MapItem() {
        super(0.0, 0, "Map");
    }

    @Override
    public void interact(Player player){
        World.map.showRooms(player);
    }
}
