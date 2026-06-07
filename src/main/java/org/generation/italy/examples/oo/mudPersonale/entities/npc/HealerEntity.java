package org.generation.italy.examples.oo.mudPersonale.entities.npc;

import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;

public class HealerEntity extends Entity {
    private static final String NAME = "Natasha La Curatrice";
    public HealerEntity() {
        super(HealerEntity.NAME);
    }

    @Override
    public void interact(Player player){
        String input = IO.readln("""
                Salve avventuriero, sono Natasha la curatrice.
                Vuoi curate i pokemon? 'Y' se sì
                """);
        if(input.equalsIgnoreCase("y")){
            System.out.println("Stai riposando...");
            player.healAllPokemon();
            System.out.println("I tuoi pokemon hanno recuperato vita");
        }else{
            IO.println("Arrivederci avventuriero");
        }
    }
}
