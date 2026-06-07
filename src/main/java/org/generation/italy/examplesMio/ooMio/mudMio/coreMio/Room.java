package org.generation.italy.examplesMio.ooMio.mudMio.coreMio;

import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.Entity;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Item;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies.Merchant;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies.Monster;

import java.util.ArrayList;

public class Room {
    private String title;
    private String description;
    private ArrayList<Entity> entities;
    private ArrayList<Item> items;
    private ArrayList<Monster> monsters;
    private ArrayList<Merchant> merchants;
    private Room[] exits;


    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int WEST = 2;
    public static final int SOUTH = 3;

    public Room(String title, String description, ArrayList<Entity> entities, ArrayList<Item> items, ArrayList<Monster> monsters, ArrayList<Merchant> merchants) {
        this.title = title;
        this.description = description;
        this.entities = entities;
        this.items = items;
        this.exits = new Room[4];
        this.monsters = monsters;
        this.merchants = merchants;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // aggiungiamo una uscita ad una stanza e diciamo anche in che direzione è l'uscita
    public boolean addExit(Room destination, int direction) {
        if (exits[direction] != null) {
            return false;
        }

        exits[direction] = destination;
        return true;
    }

    public Room exitAt(int direction) {
        return exits[direction];
    }


    public void removeItemFromRoom(Item item) {
        items.remove(item);
    }

    public ArrayList<String> getObjectNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Item item : items) {
            names.add(item.getName());
        }
        return names;
    }

    public ArrayList<String> getEntityNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Entity entity : entities) {
            names.add(entity.getName());
        }
        return names;
    }

    public ArrayList<String> getMerchantNames() {
        ArrayList<String> merchantNames = new ArrayList<>();
        for (Merchant merchant : merchants) {
            merchantNames.add(merchant.getName());
        }
        return merchantNames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.title);
        sb.append("\n===================\n");
        if (!entities.isEmpty()) {
            sb.append("\n").append(this.description).append("\n").append("In questo luogo sono presenti: ").append(getEntityNames()).append("\n");
            sb.append("\n===================\n");
        }
        if (!merchants.isEmpty()) {
            sb.append("\n").append("Ci sono i seguenti mercanti in zona: ").append(getMerchantNames()).append("\n");
            sb.append("\n===================\n");
        }
        if (!items.isEmpty()) {
            sb.append("\n").append("Vedi i seguenti oggetti: ").append(getObjectNames());
            sb.append("\n===================\n");
        }

        return sb.toString(); // ritorno la stringa che sta dentro lo StringBuilder
    }
}
