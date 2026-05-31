package org.generation.italy.examples.oo.mud.characters.enemies;

import org.generation.italy.examples.oo.mud.characters.Player;
import org.generation.italy.examples.oo.mud.equipment.Item;
import org.generation.italy.examples.oo.mud.equipment.Weapon;
import org.generation.italy.examples.oo.mud.rpg.DndClass;
import org.generation.italy.examples.oo.mud.rpg.Race;

import java.util.ArrayList;

public class Merchant extends HumanNpc {

    private ArrayList<Item> itemsToSell;

    public Merchant(int currentHp, String name, int level, Race race, String gender, DndClass dndClass, Weapon equippedWeapon, ArrayList<Item> itemsToSell) {
        super(currentHp, name, level, race, gender, dndClass, equippedWeapon);
        this.itemsToSell = itemsToSell;
    }

    public ArrayList<Item> getItemsToSell() {
        return itemsToSell;
    }

    public ArrayList<String> showItems() {
        ArrayList<String> names = new ArrayList<>();
        for (Item item : itemsToSell) {
            names.add(item.getName() + " - " + item.getValue() + "  gold");
        }
        return names;
    }


    public void sellItems(Item item, Player player) {
        if(itemsToSell != null && player.getCoins() >= item.getValue()){
            itemsToSell.remove(item);
            player.getInventory().addItem(item);
            player.removeGold(item.getValue());
            IO.println("Hai comprato " + item.getName() + "!");
        } else if(!itemsToSell.contains(item)){
            IO.println("Item non disponibile!");
        } else{
            IO.println("Non hai abbastanza gold!");
        }
    }
}
