package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Room {
    private String title;
    private String description;
    private ArrayList<Entity> entities;
    private ArrayList<Item> items;
    private Room[] exits;

    public static final int NORTH=0;
    public static final int EAST=1;
    public static final int WEST=2;
    public static final int SOUTH=3;

    public Room(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {
        this.title = title;
        this.description = description;
        this.entities = entities;
        this.items = items;
        this.exits = new Room[4];
    }

    public boolean addExit(Room destination, int direction) {
        if(exits[direction]!=null) {
            return false;
        }
        exits[direction]= destination;
        return true;
    }

    public Room exitAt(int direction) {
        return exits[direction];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.title);
        sb.append("\n").append(this.description).append("\n")
                .append("In questo luogo sono presenti: ")
                .append(getEntityNames()).append("\n")
                .append("Vedi i seguenti oggetti: ")
                .append(getObjectNames());
        return sb.toString();
    }

    public ArrayList<String> getObjectNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Item i : items) {
            names.add(i.getName());
        }
        return names;
    }

    public ArrayList<String> getEntityNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Entity e : entities) {
            names.add(e.getName());
        }
        return names;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem (Item item){
        items.add(item);
    }

    public void removeItem (Item item){
        items.remove(item);
    }


}
