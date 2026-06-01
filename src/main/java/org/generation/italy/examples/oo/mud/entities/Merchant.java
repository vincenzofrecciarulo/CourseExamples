package org.generation.italy.examples.oo.mud.entities;

import org.generation.italy.examples.oo.mud.Room;
import org.generation.italy.examples.oo.mud.items.Item;

public class Merchant extends Entity {
    private Item rewardItem;
    private boolean rewardGiven = false;

    public Merchant(String name, Room startingRoom, Item rewardItem) {
        super(name, 1, 0, 50, startingRoom);
        this.isHostile = false;
        this.rewardItem = rewardItem;
    }
    @Override
    public String interact(Player player) {
        if (rewardGiven) {
            return getName() + " dice: 'Grazie ancora per avermi salvato la vita, coraggioso eroe!'";
        }

        Room room = getCurrentRoom();
        if (room.getHostileCount() > 0) {
            return getName() + " grida disperato: 'Aiuto! Ci sono ancora dei mostri in questa stanza! Liberali e ti ricompenserò!'";
        }

        rewardGiven = true;
        room.addItem(rewardItem);
        return getName() + " esclama felice: 'Sei il mio salvatore! Come promesso, ecco la tua ricompensa: ho poggiato a terra "
                + rewardItem.getName() + ". Raccoglila pure con il comando [L]!'";
    }
}
