package org.generation.italy.examples.oo.mud;

import java.util.List;
import java.util.Random;

public class Npc extends Entity{
    private boolean hasDialogue;
    private String npcText;
    private String interactText;
    private boolean isFirstInteraction=true;


    public Npc(String name, int hp, List<Item> items, int damage, boolean hasDialogue,
                String npcText, String interactText){
        super(name,hp,items,damage);
        this.hasDialogue=hasDialogue;
        this.npcText=npcText;
        this.interactText = interactText;
    }

    public Npc(String name,int hp, int damage, Room currentRoom,String npcText) {
        super(name, hp, damage);
        this.npcText = npcText;
    }

    public String getNpcText(){
        return npcText;
    }
    public String getInteractText() {
        return interactText;
    }

    public boolean interact(Player player){
        if(!isFirstInteraction) {
            IO.println(this.getNpcText());
            return false;
        }
        if (hasDialogue) {
            IO.println(interactText);
        } else {
            IO.println("Non ho nulla da dirti");
        }
        giveReward(player);
        isFirstInteraction = false;
        return true;
    }

    public boolean giveReward(Player player){
        Random luck=new Random();
        if(!items.isEmpty()){
            int casual=luck.nextInt(getItems().size());
            Item chosed =getItems().get(casual);
            player.getItems().add(chosed);
            return true;
        }
        return false;
    }

    @Override
    public void onDeath() {
        for(Item item:getItems()){
            currentRoom.addItem(item);
        }

    }
}

