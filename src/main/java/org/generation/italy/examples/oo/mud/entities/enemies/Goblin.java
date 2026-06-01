package org.generation.italy.examples.oo.mud.entities.enemies;

import org.generation.italy.examples.oo.mud.entities.Player;

public class Goblin extends Enemy{
    public Goblin(int hp, String name, int level) {
        super(hp, name, level);
    }

    @Override
    public void interact(Player player){

    }
}
