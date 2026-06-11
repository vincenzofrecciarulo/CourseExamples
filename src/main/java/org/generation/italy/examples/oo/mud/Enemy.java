package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Entity{

    public Enemy(String name,int hp ,List<Item>items,Inventory item,String text, int damage){
        super(name,hp,items,text,damage);
    }



    @Override
    public void onDeath() {
        for(Item item:getItems()){
            currentRoom.addItem(item);
        }
    }
}
