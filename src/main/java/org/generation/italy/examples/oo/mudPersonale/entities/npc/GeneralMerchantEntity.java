package org.generation.italy.examples.oo.mudPersonale.entities.npc;

import org.generation.italy.examples.oo.mudPersonale.Inventory;
import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;
import org.generation.italy.examples.oo.mudPersonale.enums.HealPotion;
import org.generation.italy.examples.oo.mudPersonale.items.HealPotionItem;
import org.generation.italy.examples.oo.mudPersonale.items.Item;
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
                buyItem(HealPotion.SMALL, player);
                break;
            case "2":
                buyItem(HealPotion.MEDIUM, player);
                break;
            case "3":
                buyItem(HealPotion.LARGE, player);
                break;
            case "4":
                buyItem(new ScrollOfReturn(), player);
                break;
            default:
                IO.println("Arrivederci avventuriero!");
                break;
        }
    }

    private void buyItem(Item item, Player player){
        if(player.getInventoryWeight() + item.getWeight() > Inventory.MAX_WEIGHT){
            System.out.println("Non hai abbastanza spazio nello zaino..");
            return;
        }
        if(!player.withdrawCoins(item.getPrice())){
            IO.println("Eh troppo povero per comprare..?");
            return;
        }
        player.pick(item);
        IO.println("Hai comprato " + item.getName());
    }

    private void buyItem(HealPotion healPotion, Player player){
        buyItem(new HealPotionItem(healPotion), player);
    }
}
