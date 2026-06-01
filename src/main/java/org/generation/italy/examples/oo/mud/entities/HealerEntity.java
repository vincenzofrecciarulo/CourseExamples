package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.Inventory;
import org.generation.italy.examples.oo.mud.items.HealPotionItem;

public class HealerEntity extends Entity{
    private static final int HP = 1;
    private static final String NAME = "Natasha La Curatrice";
    private static final int LEVEL = 1;
    private static final int HEAL_AMOUNT = 100;
    public HealerEntity() {
        super(HealerEntity.HP, HealerEntity.NAME, HealerEntity.LEVEL);
    }

    @Override
    public void interact(Player player){
        String input = IO.readln("""
                Salve avventuriero, sono Natasha la curatrice.
                Vuoi ricevere cure gratis o comprare una pozione di cura (5 monete)?
                """);
        switch (input){
            case "1":
                System.out.println("Stai riposando...");
                player.heal(HealerEntity.HEAL_AMOUNT);
                System.out.println("Hai recuperato 100 punti vita.");
                break;
            case "2":
                if(player.getInventoryWeight() + HealPotionItem.WEIGHT > Inventory.MAX_WEIGHT){
                    System.out.println("Non hai abbastanza spazio nello zaino..");
                    return;
                }
                if(!player.withdrawCoins(5)){
                    System.out.println("Non hai abbastanza monete");
                    return;
                }
                player.pick(new HealPotionItem());
                IO.println("Hai comprato una pozione di cura");
                break;
            default:
                System.out.println("Arrivederci avventuriero..");
        }
    }
}
