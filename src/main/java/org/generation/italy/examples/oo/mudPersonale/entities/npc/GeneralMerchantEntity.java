package org.generation.italy.examples.oo.mudPersonale.entities.npc;

import org.generation.italy.examples.oo.mudPersonale.Inventory;
import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;
import org.generation.italy.examples.oo.mudPersonale.items.HealPotion;
import org.generation.italy.examples.oo.mudPersonale.items.ScrollOfReturn;

public class GeneralMerchantEntity extends Entity {
    private static final String NAME = "Therion Il Mercante";

    public GeneralMerchantEntity() {
        super(GeneralMerchantEntity.NAME);
    }

    @Override
    public void interact(Player player){
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
                IO.println("Hai comprato una pozione di cura");
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
                IO.println("Hai comprato una pergamena del ritorno");
                break;
            default:
                IO.println("Arrivederci avventuriero!");
                break;
        }
    }
}
