package org.generation.italy.examples.oo.mud.entities.npc;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;

public class GuardEntity extends Entity {
    private static final String NAME = "Ciro La Guardia";

    public GuardEntity() {
        super(GuardEntity.NAME);
    }

    @Override
    public void interact(Player player){
        IO.println("Salve avventuriero, non è una bellissima giornata?");
    }
}
