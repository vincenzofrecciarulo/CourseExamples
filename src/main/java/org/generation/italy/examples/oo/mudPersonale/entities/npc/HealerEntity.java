package org.generation.italy.examples.oo.mudPersonale.entities.npc;

import org.generation.italy.examples.oo.mudPersonale.Inventory;
import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.Player;
import org.generation.italy.examples.oo.mudPersonale.items.HealPotion;

public class HealerEntity extends Entity {
    private static final String NAME = "Natasha La Curatrice";
    private static final int HEAL_AMOUNT = 100;
    public HealerEntity() {
        super(HealerEntity.NAME);
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
                player.healAllPokemon();
                System.out.println("I tuoi pokemon hanno recuperato vita");
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
