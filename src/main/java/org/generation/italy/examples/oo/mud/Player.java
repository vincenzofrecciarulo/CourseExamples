package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Player {

    private String name;
    private int hp;
    public static final int BASE_PLAYER_HP=100;
    private Inventory backpack;
    private Room currentRoom;



    public Player(String name) {
        this.name = name;
        this.hp=BASE_PLAYER_HP;
        this.backpack=new Inventory();

    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public Inventory getBackpack(){
        return backpack;
    }


    public boolean pickItem(String itemName){
        for(Item item:currentRoom.getItems()){
            if(!itemName.equalsIgnoreCase(item.getName())){
                continue;
            }else {
                currentRoom.removeItem(item);
                backpack.addItem(item);
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
            for(Item item: backpack.getBackPack()){
                if(itemDropped.equalsIgnoreCase(item.getName())){
                    backpack.removeItem(item);
                    currentRoom.addItem(item);
                    return true;
                }
                }
                IO.println("Item non trovato");
        }while(true);
    }

    public void talkToNpc() {
        boolean hasTalked=false;
        ArrayList<Npc>npcsInRoom=new ArrayList<>();
        for(Entity e: currentRoom.getEntities()) {
            if(e instanceof Npc){
                npcsInRoom.add((Npc)e);
            }
        }
            if(npcsInRoom.isEmpty()){
                return;
            }
            if(npcsInRoom.size()==1){
                Npc alone=npcsInRoom.get(0);
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

}
