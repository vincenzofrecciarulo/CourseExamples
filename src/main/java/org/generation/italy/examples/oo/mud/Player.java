package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Iterator;

public class Player extends Entity {
    private ArrayList<Item> inventory;
    private Item equipped;

    public Player(int hp, String name, int level) {
        super(hp, name, level);
        this.inventory = new ArrayList<>();
        this.equipped = null;
    }

    public boolean pickUp(Item item){
        if(item==null) return false;
        return inventory.add(item);
    }

    public Optional<Item> drop(String name){
        /*
        // Old version: removing from a list inside an enhanced for-loop is fragile
        // because it mixes iteration and mutation in the same structure.
        for(Item i: inventory){
            if(i.getName().equalsIgnoreCase(name)){
                inventory.remove(i);
                if(equipped==i) equipped = null;
                return Optional.of(i);
            }
        }
        */
        var it = inventory.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().equalsIgnoreCase(name)){
                it.remove();
                if(equipped==i) equipped = null;
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public boolean equip(String name){
        for(Item i: inventory){
            if(i.getName().equalsIgnoreCase(name)){
                this.equipped = i;
                return true;
            }
        }
        return false;
    }

    /** Drop an item by prefix match (case-insensitive) */
    public Optional<Item> dropByPrefix(String prefix){
        if(prefix==null || prefix.isEmpty()) return Optional.empty();
        String lower = prefix.toLowerCase();
        var it = inventory.iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().toLowerCase().startsWith(lower)){
                it.remove();
                if(equipped==i) equipped = null;
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /** Equip an item by prefix match (case-insensitive) */
    public boolean equipByPrefix(String prefix){
        if(prefix==null || prefix.isEmpty()) return false;
        String lower = prefix.toLowerCase();
        for(Item i: inventory){
            if(i.getName().toLowerCase().startsWith(lower)){
                this.equipped = i;
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getInventoryNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Item i: inventory) names.add(i.getName());
        return names;
    }

    public Item getEquipped(){
        return equipped;
    }
}
