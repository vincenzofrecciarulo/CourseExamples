package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class TempleRoom extends Room {
    private static final int HEAL_AMOUNT = 100;
    private static final String TITLE = "Piazza del Tempio";
    private static final String DESCRIPTION = "Qui vengono a curarsi gli avventurieri malati!";


    public TempleRoom(){
        super(TempleRoom.TITLE, TempleRoom.DESCRIPTION, new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public void interact(Player player){
        String input = IO.readln("""
                """);
        if(input.equals("y")){
            if(!player.withdrawCoins(5)){
                System.out.println("Non hai abbastanza monete");
                return;
            }
            System.out.println("Stai riposando...");
            player.heal(HEAL_AMOUNT);
            System.out.println("Hai recuperato 100 punti vita.");
        }
    }


}
