package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.Room;
import org.generation.italy.examples.oo.mud.Utils;
import org.generation.italy.examples.oo.mud.items.Weapon;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Entity {
    private ArrayList<Item> inventory = new ArrayList<>();
    private final int INVENTORY_SLOTS = 20;
    private final double MAX_WEIGHT = 50.0;

    public Player(String name, Room startingRoom){
        super(name, 1, 10, 100, startingRoom);
    }

    public double getCurrentWeight() {
        double totalWeight = 0.0;
        for (Item i : inventory) {
            totalWeight += i.getWeight();
        }
        return totalWeight;
    }

    public String showInventory(){
        String msg = "L'INVENTARIO E' VUOTO";
        if(inventory.isEmpty()) return msg;
        IO.println("INVENTARIO: ");
        System.out.printf("%-20s | %-20s| %-20s| %n", "ITEM", "VALORE", "PESO");
        for(Item i: inventory){
            System.out.printf("%-20s | %-20.2f| %-20.2f| %n", i.getName(), i.getValue(), i.getWeight());
        }

        System.out.printf("%nPESO TOTALE: %.2f / %.2f kg %n", getCurrentWeight(), MAX_WEIGHT);

        msg = "Per droppare un item selezionare [D] \n" +
                "Per uscire dall'inventario selezionare [E]\n" +
                "Per usare un oggetto [U]\n" +
                "Per smettere di usare un oggetto [L]";
        switch(Utils.choice(msg, "d", "e", "u", "l")){
            case "d":
                String[] itemsNames = new String[inventory.size()];
                for(int i = 0; i < inventory.size(); i++){
                    itemsNames[i] = inventory.get(i).getName();
                }
                msg = this.dropItem(Utils.choice("Inserire il nome dell'item da eliminare", itemsNames));
                break;
            case "u":
                itemsNames = new String[inventory.size()];
                for(int i = 0; i < inventory.size(); i++){
                    itemsNames[i] = inventory.get(i).getName();
                }
                msg = this.useItem(Utils.choice("Inserire il nome dell'item da usare", itemsNames), true);
                break;
            case "l":
                itemsNames = new String[inventory.size()];
                for(int i = 0; i < inventory.size(); i++){
                    itemsNames[i] = inventory.get(i).getName();
                }
                msg = this.useItem(Utils.choice("Inserire il nome dell'item da usare", itemsNames), false);
                break;
            case "e":
                break;
        }
        return msg;
    }

    public String pickUpItem(String item){
        StringBuilder sb = new StringBuilder();
        Item[] roomItems = getCurrentRoom().getRoomItems();

        if(inventory.size() >= INVENTORY_SLOTS) {
            sb.append("IMPOSSIBILE RACCOGLIERE L'OGGETTO ").append(item.toUpperCase()).append(": Inventario Pieno!\n");
            return sb.toString();
        }

        for (Item i : roomItems){
            if(i.isNamed(item)){
                if (this.getCurrentWeight() + i.getWeight() > MAX_WEIGHT) {
                    sb.append("L'OGGETTO ").append(item.toUpperCase()).append(" E' TROPPO PESANTE! Supereresti il limite di carico.\n");
                } else {
                    inventory.add(i);
                    sb.append("HAI OTTENUTO ").append(item);
                    getCurrentRoom().removeItem(item);
                }
                break;
            }
        }
        return sb.toString();
    }

    public String useItem(String item, boolean equip){
        if(equip){
            for(Item i: inventory){
                if(i.getName().equalsIgnoreCase(item)) return i.use(this);
            }
        }
        else {
            for(Item i: inventory){
                if(i.getName().equalsIgnoreCase(item)) return i.unUse(this);
            }
        }
        return "Oggetto non trovato nell'inventario.";
    }

    public boolean inventoryIsEmpty(){
        return inventory.size() == 0;
    }

    public String dropItem(String item){
        boolean removed = false;
        StringBuilder sb = new StringBuilder();
        for (Item i: inventory){
            if(i.isNamed(item) ){
                if(i.isDroppable()) {
                    getCurrentRoom().addItem(i);
                    removed = removeFromInventory(i);
                    sb.append(String.format("Item %s rimosso dall'inventario\n", item));
                    break;
                } else sb.append(String.format("Item %s non puo' essere rimosso dall'inventario", item));
            }
        }
        if(!removed) sb.append(String.format("Item %s non e' presente nell'inventario", item));
        return sb.toString();
    }

    public boolean removeFromInventory(Item item){
        return inventory.remove(item);
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }
}
