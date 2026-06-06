package org.generation.italy.examples.oo.mud;

public class Commands {
    Player player;

    public Commands(Player player) {
        this.player=player;
    }

    public void handlePick(String itemName){
        player.pickItem(itemName);
    }


}
