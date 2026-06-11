package org.generation.italy.examples.oo.mud;

import java.util.List;
import java.util.Random;

public class Npc extends Entity{
    private boolean hasDialogue;
    private String interactText;
    private boolean isFirstInteraction=true;


    public Npc(String name, int hp, List<Item> items,String text, int damage, boolean hasDialogue,
             String interactText){
        super(name,hp,items,text,damage);
        this.hasDialogue=hasDialogue;
        this.interactText = interactText;
    }

    public Npc(String name,int hp,String text, int damage, Room currentRoom) {
        super(name, hp,text, damage);
        this.currentRoom=currentRoom;


    }


    public String getInteractText() {
        return interactText;
    }



    public boolean giveReward(Player player){
        Random luck=new Random();
        if(!getItems().isEmpty()){
            int casual=luck.nextInt(getItems().size());
            Item chosed =getItems().get(casual);
            player.getItems().add(chosed);
            IO.println("Hai ricevuto "+chosed+ " da "+this);
            return true;
        }
        return false;
    }


    public boolean interact(Player p) {
            if(!isFirstInteraction) {
                IO.println(getText());
                return false;
            }
            if (hasDialogue) {
                IO.println(interactText);
            } else {
                IO.println("Non ho nulla da dirti");
            }
            giveReward(p);
            isFirstInteraction = false;
            return true;
        }




    @Override
    public void onDeath() {
        for(Item item:getItems()){
            currentRoom.addItem(item);
        }

    }
}

