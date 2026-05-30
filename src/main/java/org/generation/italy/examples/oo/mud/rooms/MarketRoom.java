package org.generation.italy.examples.oo.mud.rooms;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.HealPotion;
import org.generation.italy.examples.oo.mud.items.ScrollOfReturn;

import java.util.ArrayList;

public class MarketRoom extends Room {
    private static final String TITLE = "Piazza del Mercato";
    private static final String DESCRIPTION = "Qui vengono a curarsi gli avventurieri malati!";

    public MarketRoom(){
        super(TITLE, DESCRIPTION, new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public void interact(Player player) {
        String input = IO.readln("""
                Ciao avventuriero, vuoi comprare qualcosa?
                - '1' pozione di cura 50 vita (costo 10 monete)
                - '2' scroll del ritorno (costo 5 monete);
                """);

        switch (input){
            case "1":
                if(player.getInventoryWeight() + HealPotion.WEIGHT > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(10)){
                    IO.println("Eh troppo povero per comprare..?");
                }
                player.pick(new HealPotion());
                break;
            case "2":
                if(player.getInventoryWeight() + ScrollOfReturn.WEIGHT > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(5)){
                    IO.println("Eh troppo povero per comprare..?");
                }
                player.pick(new ScrollOfReturn());
                break;
            default:
                IO.println("Arrivederci avventuriero!");
                break;
        }

    }
}
