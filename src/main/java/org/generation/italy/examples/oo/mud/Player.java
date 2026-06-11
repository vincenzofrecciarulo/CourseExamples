package org.generation.italy.examples.oo.mud;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {

    public Player(String name, int hp, List<Item> items, String text,int damage) {
        super(name,hp,items,"",5);
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

    public boolean dropItem(String itemDropped){
            for(Item item: items) {
                if (itemDropped.equalsIgnoreCase(item.getName())) {
                    items.remove(item);
                    currentRoom.addItem(item);
                    return true;
                }
            }
            return false;

    }

    public boolean talkTo(Entity e) {
        if(e instanceof Npc){
            ((Npc) e).interact(this);
        }else {
            IO.println(e.getText());
        }
        return true;
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
