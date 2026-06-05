package org.generation.italy.examples.oo.mud.world;

import java.util.ArrayList;
import java.util.Iterator;

public class Room {
    private String title;
    private String description;
    private ArrayList<Entity> entities;
    private ArrayList<Item> items;
    private Room[] exits;

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int WEST = 2;
    public static final int SOUTH = 3;

    public Room(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {
        this.title = title;
        this.description = description;
        this.entities = entities;
        this.items = items;
        this.exits = new Room[4];
    }

    // safe getters in case nulls were passed in
    public ArrayList<Entity> getEntities(){
        if(entities==null) entities = new ArrayList<>();
        return entities;
    }

    public ArrayList<Item> getItems(){
        if(items==null) items = new ArrayList<>();
        return items;
    }

    // aggiungiamo una uscita ad una stanza e diciamo anche in che direzione è l'uscita
    public boolean addExit(Room destination, int direction){
        if(exits[direction]!=null){
            return false;
        }

        exits[direction] = destination;
        return true;
    }

    public Room exitAt(int direction){
        return exits[direction];
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(this.title);
        sb.append("\n").append(this.description).append("\n")
                .append("In questo luogo sono presenti: ")
                .append(getEntityNames()).append("\n")
                .append("Vedi i seguenti oggetti: ")
                .append(getObjectNames()).append("\n")
                .append("Uscite: [").append(getExitString()).append("]");
        return sb.toString(); // ritorno la stringa che sta dentro lo StringBuilder
    }

    public ArrayList<String> getObjectNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Item i : getItems()){
            names.add(i.getName());
        }
        return names;
    }

    public ArrayList<String> getEntityNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Entity e : getEntities()){
            if(!(e instanceof Player)){
                names.add(e.getName());
            }
        }
        return names;
    }

    public String getExitString(){
        StringBuilder exitsText = new StringBuilder();
        if(exitAt(NORTH) != null){
            exitsText.append("n");
        }
        if(exitAt(EAST) != null){
            exitsText.append("e");
        }
        if(exitAt(SOUTH) != null){
            exitsText.append("s");
        }
        if(exitAt(WEST) != null){
            exitsText.append("w");
        }
        return exitsText.toString();
    }

    // Mutators for items and entities
    public void addItem(Item item){
        getItems().add(item);
    }

    public Item removeItemByName(String name){
        Iterator<Item> it = getItems().iterator();
        while(it.hasNext()){
            Item i = it.next();
            if(i.getName().equalsIgnoreCase(name)){
                it.remove();
                return i;
            }
        }
        return null;
    }

    public void addEntity(Entity e){
        getEntities().add(e);
    }

    public boolean removeEntity(Entity e){
        return getEntities().remove(e);
    }

    /** Return players (instances of Player) currently in this room */
    public ArrayList<Player> getPlayers(){
        ArrayList<Player> players = new ArrayList<>();
        for(Entity e: getEntities()){
            if(e instanceof Player) players.add((Player)e);
        }
        return players;
    }

    /**
     * Find an item by prefix match (case-insensitive).
     * Returns the item whose name starts with the given prefix, or null if none found.
     * If multiple items match, returns the first one.
     */
    public Item findItemByPrefix(String prefix){
        if(prefix==null || prefix.isEmpty()) return null;
        String lower = prefix.toLowerCase();
        for(Item i: getItems()){
            if(i.getName().toLowerCase().startsWith(lower)){
                return i;
            }
        }
        return null;
    }

    /**
     * Find an entity by prefix match (case-insensitive).
     * Returns the entity whose name starts with the given prefix, or null if none found.
     * If multiple entities match, returns the first one.
     */
    public Entity findEntityByPrefix(String prefix){
        if(prefix==null || prefix.isEmpty()) return null;
        String lower = prefix.toLowerCase();
        for(Entity e: getEntities()){
            if(e.getName().toLowerCase().startsWith(lower)){
                return e;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
