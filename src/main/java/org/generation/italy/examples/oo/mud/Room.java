package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Room {
    private String title;
    private String description;
    private ArrayList<NPC> npcs;
    private ArrayList<Entity> entities;
    private ArrayList<Item> items;
    private Room[] exits;

    public static final int NORTH = 0;
    public static final int EAST  = 1;
    public static final int WEST  = 2;
    public static final int SOUTH = 3;

    public Room(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {
        this.title = title;
        this.description = description;
        this.entities = entities;
        this.items = items;
        this.exits = new Room[4];
    }

    public boolean addExit(Room destination, int direction) {
        if (exits[direction] != null) return false;
        exits[direction] = destination;
        return true;
    }

    public Room exitAt(int direction) {
        return exits[direction];
    }

    // Ritorna solo i Monster vivi presenti nella stanza
    public ArrayList<Monster> getMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        for (Entity e : entities) {
            if (e instanceof Monster && ((Monster) e).isAlive()) {
                monsters.add((Monster) e);
            }
        }
        return monsters;
    }

    // Rimuove i mostri morti dalla lista entities
    public void removeDeadMonsters() {
        entities.removeIf(e -> e instanceof Monster && !((Monster) e).isAlive());
    }

    public boolean hasLivingMonsters() {
        return !getMonsters().isEmpty();
    }

    @Override
    public String toString() {
        return title + "\n" + description + "\n";
    }

    public String infoRoom() {
        StringBuilder ir = new StringBuilder();
        ir.append("In questo luogo sono presenti: ")
                .append(getEntityNames()).append("\n")
                .append("Vedi i seguenti oggetti: ")
                .append(getObjectNames());
        return ir.toString();
    }

    public String interact() {
        StringBuilder in = new StringBuilder();
        for (String name : getNPCNames()) {
            in.append(name).append("\n");
        }
      return in.toString();
    }

    public ArrayList<String> getObjectNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Item i : items) names.add(i.getName());
        return names;
    }

    public ArrayList<String> getEntityNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Entity e : entities) names.add(e.getName());
        return names;
    }

    public ArrayList<String> getNPCNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Entity e : entities) {
            if (e instanceof NPC n) {        // pattern matching Java 16+
                names.add(n.getName());
            }
        }
        return names;
    }

    public NPC getFirstNPC() {
        for (Entity e : entities) {
            if (e instanceof NPC) return (NPC) e;
        }
        return null;
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    public ArrayList<NPC> getNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();
        for (Entity e : entities) {
            if (e instanceof NPC n && n.isAlive()) {
                npcs.add(n);
            }
        }
        return npcs;
    }

    public boolean hasNPCs() {
        for (Entity e : entities) {
            if (e instanceof NPC) return true;
        }
        return false;
    }

    public ArrayList<Item> getItems()       { return items; }
    public void addItem(Item item)          { items.add(item); }
    public void removeItem(Item item)       { items.remove(item); }
    public String getTitle()                { return title; }
    public String getDescription()          { return description; }
}
