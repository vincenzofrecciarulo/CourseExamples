package org.generation.italy.examples.oo.mudPersonale.entities.npc;

import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;

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
