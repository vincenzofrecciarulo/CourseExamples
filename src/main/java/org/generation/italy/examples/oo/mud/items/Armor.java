package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.entities.Player;

public class Armor extends Item {
    private int armorBonus;
    public Armor(String name, int armorBonus, double value, boolean coursed) {
        // Peso fisso a 15 per le armature, droppabili solo se non maledette
        super(name, value, 15.0, !coursed);
        this.armorBonus = armorBonus;
        this.type = 'a';
    }
    public int getArmorBonus() {
        return armorBonus;
    }
    @Override
    public String use(Player player) {
        if (this.isInUse()) return "Stai già indossando questa armatura.";
        for (Item i : player.getInventory()) {
            if (i.getType() == 'a' && i.isInUse()) {
                return "Stai già indossando un'altra armatura! Devi prima toglierla.";
            }
        }
        player.setArmor(armorBonus);
        super.use(player); // Imposta inUse = true
        return "Hai indossato con successo " + this.getName() + ". La tua difesa aumenta di " + armorBonus + "!";
    }
    @Override
    public String unUse(Player player) {
        if (!this.isInUse()) return this.getName() + " non è in uso.";

        player.setArmor(0);
        super.unUse(player);
        return "Ti sei tolto " + this.getName();
    }
}
