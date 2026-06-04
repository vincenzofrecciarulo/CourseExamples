package org.generation.italy.examples.oo.mud;

import com.generation.library.Console;

import java.util.ArrayList;

public class Player extends Entity {

    private ArrayList<Item> inventory = new ArrayList<>();
    private Armor wornArmor = null;
    private Weapon wornWeapon = null;
    private Room currentRoom;

    public Player(int hp, String name, int level, Room currentRoom) {
        super(hp, name, level);
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getInventory() { return inventory; }
    public Room getCurrentRoom()          { return currentRoom; }
    public Armor getWornArmor()           { return wornArmor; }
    public Weapon getWornWeapon()         { return wornWeapon; }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }



    public boolean pickItem(Item item) {
        if (!currentRoom.getItems().contains(item)) {
            IO.println("Oggetto " + item.getName() + " non c'è nella stanza.");
            return false;
        }
        currentRoom.getItems().remove(item);
        inventory.add(item);
        return true;
    }

    public boolean dropItem(Item item) {
        if (!inventory.contains(item)) {
            IO.println("Oggetto " + item.getName() + " non trovato nell'inventario.");
            return false;
        }

        if (item == wornArmor) {
            wornArmor.remove();
            wornArmor = null;
        }
         else if (item == wornWeapon) {
            wornWeapon.remove();
            wornWeapon = null;
        }

        inventory.remove(item);
        currentRoom.getItems().add(item);
        return true;
    }



    public boolean useItem(Item item) {
        if (!inventory.contains(item)) {
            IO.println("Non hai " + item.getName() + " nell'inventario.");
            return false;
        }
        if (item instanceof Consumable) {
            return ((Consumable) item).use(this);
        }
        if (item instanceof Armor) {
            return wearArmor((Armor) item);
        }
        if (item instanceof Weapon) {
            return wearWeapon((Weapon) item);
        }
        IO.println("Non puoi usare " + item.getName() + " in questo modo.");
        return false;
    }


    public boolean wearArmor(Armor armor) {
        if (!inventory.contains(armor)) {
            IO.println("Non hai " + armor.getName() + " nell'inventario.");
            return false;
        }
        if (wornArmor != null) {
            IO.println("Togli " + wornArmor.getName() + " e indossi " + armor.getName() + ".");
            wornArmor.remove();
        } else {
            IO.println("Indossi " + armor.getName() + " (DEF +" + armor.getDefense() + ").");
        }
        wornArmor = armor;
        armor.wear();
        return true;
    }


    public int getTotalDefense() {
        return wornArmor != null ? wornArmor.getDefense() : 0;
    }


    public boolean wearWeapon(Weapon weapon) {
        if (!inventory.contains(weapon)) {
            IO.println("Non hai " + weapon.getName() + " nell'inventario.");
            return false;
        }
        if (wornWeapon != null) {
            IO.println("Togli " + wornWeapon.getName() + " e indossi " + weapon.getName() + ".");
            wornWeapon.remove();
        } else {
            IO.println("Indossi " + weapon.getName() + " (POW +" + weapon.getPower() + ").");
        }
        wornWeapon = weapon;
        weapon.wear();
        return true;
    }

    public int getTotalPower() {
        return wornWeapon != null ? wornWeapon.getPower() : 0;
    }


    public boolean openInventory() {
        if (inventory.isEmpty()) {
            IO.println("Inventario vuoto!");
            return true;
        }
        IO.println("── Inventario ──────────────────────────");
        IO.println("  HP: " + getHpBar());
        IO.println("  Armatura: " + (wornArmor != null ? wornArmor.getName() + " (DEF " + wornArmor.getDefense() + ")" : "nessuna"));
        IO.println("  Arma: " + (wornWeapon != null ? wornWeapon.getName() + " (POW " + wornWeapon.getPower() + ")" : "nessuna"));
        IO.println("  Oggetti:");
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            String tag = "";
            if (item == wornArmor)             tag = " [indossata]";
            else if (item instanceof Consumable) tag = " [consumabile]";
            else if (item instanceof Armor)      tag = " [armatura]";
            else if (item instanceof Weapon)      tag = " [arma]";
            IO.println("    " + i + ". " + item.getName() + tag);
        }
        IO.println("────────────────────────────────────────");
        return true;
    }
    public void useItemMenu() {
        ArrayList<Item> inv = getInventory();
        if (inv.isEmpty()) {
            IO.println("Il tuo inventario è vuoto.");
            return;
        }
        openInventory();
        IO.println("Quale oggetto vuoi usare? (o -1 per annullare)");
        int idx = Console.readInt();
        if (idx < 0 || idx >= inv.size()) {
            IO.println("Scelta annullata.");
            return;
        }
        useItem(inv.get(idx));
    }

}
