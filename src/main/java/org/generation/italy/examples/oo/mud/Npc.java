package org.generation.italy.examples.oo.mud;

public class Npc extends Entity{
    private boolean hasDialogue=true;
    private Item reward;
    private String npcText;
    private String interactText;
    private boolean isFirstInteraction=true;

    public Npc(String name,int hp,int level,boolean hasDialogue,Item reward,String npcText,String interactText){
        super(name,hp,level);
        this.hasDialogue=hasDialogue;
        this.reward=reward;
        this.npcText=npcText;
        this.interactText = interactText;
    }

    public boolean isHasDialogue() {
        return hasDialogue;
    }

    public Item getReward() {
        return reward;
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
        if(reward!=null){
            player.getBackpack().addItem(reward);
            reward=null;
            return true;
        }
        return false;
    }

}

