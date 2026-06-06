package org.generation.italy.examples.oo.mud;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {



    public Player(String name, int hp, List<Item> items, int damage) {
        super(name,hp,items,5);

    }

    public boolean pickItem(String itemName){
        for(Item item:currentRoom.getItems()){
            if(!itemName.equalsIgnoreCase(item.getName())){
                continue;
            }else {
                currentRoom.removeItem(item);
                this.getItems().add(item);
                return true;
            }
        }
        return false;
        }

    public boolean dropItem(){
        do {
            String itemDropped=IO.readln("Digita il nome dell' item vuoi droppare o quit?");
            if(itemDropped.equalsIgnoreCase("quit")){
                return false;
            }
            for(Item item: items){
                if(itemDropped.equalsIgnoreCase(item.getName())){
                    items.remove(item);
                    currentRoom.addItem(item);
                    return true;
                }
                }
                IO.println("Item non trovato");
        }while(true);
    }

    public void talkToNpc() {
        boolean hasTalked=false;
        java.util.ArrayList<Npc> npcsInRoom=new java.util.ArrayList<>();
        for(Entity e: currentRoom.getEntities()) {
            if(e instanceof Npc){
                npcsInRoom.add((Npc)e);
            }
        }
            if(npcsInRoom.isEmpty()){
                return;
            }
            if(npcsInRoom.size()==1){
                Npc alone=npcsInRoom.getFirst();
                alone.interact(this);
                hasTalked=true;
            }else {
                do {
                    String npcChosed = IO.readln("Qui ci sono " + this.getCurrent().getEntityNames() +
                            " con chi vuoi parlare? ");
                    boolean found =false;
                    for (Npc npc : npcsInRoom) {
                        if (npcChosed.equalsIgnoreCase(npc.getName())) {
                            npc.interact(this);
                            hasTalked=true;
                            found=true;
                        }
                    }
                    if (!found) {
                        IO.println("Non ho capito");
                    }
                }while(!hasTalked);
            }
    }


    public Room getCurrent(){
        return currentRoom;
    }
    public void setCurrent(Room room){
        this.currentRoom=room;
    }


    @Override
    public void onDeath() {
        IO.println("Sei morto");
    }
}
