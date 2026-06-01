package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.items.HealPotionItem;
import org.generation.italy.examples.oo.mud.items.ScrollOfReturnItem;

public class GeneralMerchantEntity extends Entity{
    private static final int HP = 1;
    private static final String NAME = "Therion Il Mercante";
    private static final int LEVEL = 1;

    public GeneralMerchantEntity() {
        super(GeneralMerchantEntity.HP, GeneralMerchantEntity.NAME, GeneralMerchantEntity.LEVEL);
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
                if(player.getInventoryWeight() + HealPotionItem.WEIGHT > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(10)){
                    IO.println("Eh troppo povero per comprare..?");
                }
                player.pick(new HealPotionItem());
                IO.println("Hai comprato una pozione di cura");
                break;
            case "2":
                if(player.getInventoryWeight() + ScrollOfReturnItem.WEIGHT > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(5)){
                    IO.println("Eh troppo povero per comprare..?");
                }
                player.pick(new ScrollOfReturnItem());
                IO.println("Hai comprato una pergamena del ritorno");
                break;
            default:
                IO.println("Arrivederci avventuriero!");
                break;
        }
    }
}
