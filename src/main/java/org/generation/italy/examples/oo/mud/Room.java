package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String title;
    private String description;
    private List<Entity> entities;
    private List<Item> items;
    private Room[] exits;

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int WEST = 2;
    public static final int SOUTH = 3;

    public Room(String title, String description, List<Entity> entities, List<Item> items) {
        this.title = title;
        this.description = description;
        this.entities = entities;
        this.items = items;
        this.exits = new Room[4];
        for(Entity e: entities){
            e.setCurrentRoom(this);
        }
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
                .append(getObjectNames());
        return sb.toString(); // ritorno la stringa che sta dentro lo StringBuilder
    }

    public List<String> getObjectNames(){
        List<String> names = new ArrayList<>();
        for(Item i : items){
            names.add(i.getName());
        }
        return names;
    }

    public ArrayList<String> getEntityNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Entity e : entities){
            names.add(e.getName());
        }
        return names;
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public void addItem(Item item){
        items.add(item);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public Entity findEntity(String inputName){
        for(Entity e: entities){
            if(e.getName().equalsIgnoreCase(inputName))
                return e;
        }
        return null;
    }
}
