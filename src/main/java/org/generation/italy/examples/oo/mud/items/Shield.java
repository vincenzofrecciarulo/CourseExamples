package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.entities.Player;

public class Shield extends Item {
    private int shieldBonus;

    public Shield(String name, int shieldBonus, double value, boolean coursed) {
        // Peso medio a 8.0 per gli scudi, droppabili solo se non maledetti
        super(name, value, 8.0, !coursed);
        this.shieldBonus = shieldBonus;
        this.type = 's';
    }

    public int getShieldBonus() {
        return shieldBonus;
    }

    @Override
    public String use(Player player) {
        if (this.isInUse()) return "Stai già impugnando questo scudo.";

        // Controlliamo se c'è già uno scudo attivo
        for (Item i : player.getInventory()) {
            if (i.getType() == 's' && i.isInUse()) {
                return "Stai già impugnando un altro scudo!";
            }
        }

        // Applichiamo il bonus usando setShield ereditato da Entity
        player.setShield(shieldBonus);
        super.use(player); // Imposta inUse = true
        return "Hai equipaggiato lo scudo " + this.getName() + ". Ora puoi parare i colpi!";
    }
    @Override
    public String unUse(Player player) {
        if (!this.isInUse()) return this.getName() + " non è in uso.";

        player.setShield(0);
        super.unUse(player);
        return "Hai riposto lo scudo " + this.getName();
    }
}
