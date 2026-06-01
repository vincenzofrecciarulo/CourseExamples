package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.World;
import org.generation.italy.examples.oo.mud.entities.Player;

public class MapItem extends Item{
    public MapItem() {
        super(0.0, 0, "Map");
    }

    @Override
    public void interact(Player player){
        World.map.showRooms(player);
    }
}
