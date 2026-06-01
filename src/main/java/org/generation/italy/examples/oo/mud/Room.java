package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.List; // Importato per sicurezza se serve in futuro

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

    // Costruttore pulito e unico
    public Room(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items) {
        this.title = title;
        this.description = description;
        this.entities = entities;
        this.items = items;
        this.exits = new Room[4]; // Array fisso per le 4 direzioni cardinali
    }

    // Aggiunge un'uscita alla stanza nella direzione specificata
    public boolean addExit(Room destination, int direction) {
        if (exits[direction] != null) {
            return false; // Uscita già occupata
        }
        exits[direction] = destination;
        return true;
    }

    // Restituisce la stanza presente in quella direzione
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

    // Estrae i nomi degli oggetti per la stampa
    public ArrayList<String> getObjectNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Item i : items) {
            names.add(i.getName());
        }
        return names;
    }

    // Estrae i nomi delle entità (mostri/NPC) per la stampa
    public ArrayList<String> getEntityNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Entity e : entities) {
            names.add(e.getName());
        }
        return names;
    }

    // Getters standard
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}