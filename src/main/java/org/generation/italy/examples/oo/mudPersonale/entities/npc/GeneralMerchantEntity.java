package org.generation.italy.examples.oo.mudPersonale.entities.npc;

import org.generation.italy.examples.oo.mudPersonale.Inventory;
import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;
import org.generation.italy.examples.oo.mudPersonale.enums.HealPotion;
import org.generation.italy.examples.oo.mudPersonale.items.HealPotionItem;
import org.generation.italy.examples.oo.mudPersonale.items.ScrollOfReturn;

public class GeneralMerchantEntity extends Entity {
    private static final String NAME = "Therion Il Mercante";

    public GeneralMerchantEntity() {
        super(GeneralMerchantEntity.NAME);
    }

    @Override
    public void interact(Player player){
        System.out.printf("""
                 Ciao avventuriero, vuoi comprare qualcosa?
                - '1' %s %s
                - '2' %s %s
                - '3' %s %s
                - '4' %s %s
                """,
                HealPotion.SMALL.getName(), HealPotion.SMALL.getPrice(),
                HealPotion.MEDIUM.getName(), HealPotion.MEDIUM.getPrice(),
                HealPotion.LARGE.getName(), HealPotion.LARGE.getPrice(),
                ScrollOfReturn.NAME, ScrollOfReturn.PRICE);
        String input = IO.readln("->");

        switch (input){
            case "1":
                if(player.getInventoryWeight() + HealPotion.SMALL.getWeight() > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(HealPotion.SMALL.getPrice())){
                    IO.println("Eh troppo povero per comprare..?");
                    return;
                }
                player.pick(new HealPotionItem(HealPotion.SMALL));
                IO.println("Hai comprato una pozione di cura");
                break;

            case "2":
                if(player.getInventoryWeight() + HealPotion.MEDIUM.getWeight() > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(HealPotion.MEDIUM.getPrice())){
                    IO.println("Eh troppo povero per comprare..?");
                    return;
                }
                player.pick(new HealPotionItem(HealPotion.MEDIUM));
                IO.println("Hai comprato una pozione di cura");
                break;

            case "3":
                if(player.getInventoryWeight() + HealPotion.LARGE.getWeight() > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(HealPotion.MEDIUM.getPrice())){
                    IO.println("Eh troppo povero per comprare..?");
                    return;
                }
                player.pick(new HealPotionItem(HealPotion.MEDIUM));
                IO.println("Hai comprato una pozione di cura");
                break;
            case "4":
                if(player.getInventoryWeight() + ScrollOfReturn.WEIGHT > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(5)){
                    IO.println("Eh troppo povero per comprare..?");
                    return;
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
