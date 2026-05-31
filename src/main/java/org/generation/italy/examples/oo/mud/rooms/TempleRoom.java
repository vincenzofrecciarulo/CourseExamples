package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.HealPotion;

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
                Salve avventuriero, il tempio ti benedice!
                - '1' riposa nel tempio
                - '2' compra heal potion (costo 5 gold)\s
               \s""");
        switch (input){
            case "1":
                System.out.println("Stai riposando...");
                player.heal(TempleRoom.HEAL_AMOUNT);
                System.out.println("Hai recuperato 100 punti vita.");
                break;
            case "2":
                if(player.getInventoryWeight() + HealPotion.WEIGHT > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(5)){
                    System.out.println("Non hai abbastanza monete");
                    return;
                }
                player.pick(new HealPotion());
                IO.println("Hai comprato una pozione di cura");
                break;
            default:
                System.out.println("Arrivederci avventuriero..");
        }

    }



}
