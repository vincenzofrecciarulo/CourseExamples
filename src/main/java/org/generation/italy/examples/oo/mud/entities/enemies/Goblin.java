package org.generation.italy.examples.oo.mud.entities.enemies;

import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.Room;
import org.generation.italy.examples.oo.mud.Utils;
import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;

import java.util.ArrayList;
import java.util.Random;

public class Goblin extends Enemy{
    private final int STEALING_ABILITY=70;
    public Goblin(String difficulty, Room startingRoom,int level){
        super("Goblin",1,3,20,difficulty,startingRoom);
        if(level>1) this.levelUp(level-1);

    }
    @Override
    public String attack(Entity target) throws InterruptedException {
        String msg=super.attack(target);
        if(Utils.throwDice(getLuck())>STEALING_ABILITY)   stealRandomItem((Player)target);
        return msg;
    }
    @Override
    public void die(){
        IO.println("GOBLIN e' morto ");
        boolean drop=false;
        StringBuilder sb=new StringBuilder();
        if(!loot.isEmpty()){
            sb.append("Morendo ha lasciato cadere: \n");
            for (Item i : loot) {
                if(i.isDroppable()) {
                    drop=true;
                    getCurrentRoom().addItem(i);
                    sb.append("- ").append(i.getName());
                }
            }
            if(drop) IO.println(sb.toString());
            setCurrentRoom(null);

        }
    }
    public void stealRandomItem(Player player){
        if(player.inventoryIsEmpty()) return;
        ArrayList<Item> inventory= player.getInventory();
        Random random= new Random();
        int position=random.nextInt(0, inventory.size());
        Item item=inventory.get(position);
        player.removeFromInventory(item);
        this.loot.add(item);
        IO.println("Durante l'attacco, GOBLIN ha rubato "+item.getName()+" da "+player.getName());
    }

}
