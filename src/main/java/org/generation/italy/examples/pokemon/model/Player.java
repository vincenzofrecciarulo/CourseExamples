package org.generation.italy.examples.pokemon.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final String name;
    private Pokemon activePokemon;
    private int money;
    private final Map<String, Integer> inventory;       // item name -> quantity
    private final List<Pokemon> caughtPokemon;          // caught (not in party)

    public Player(String name) {
        this.name = name;
        this.money = 3000;
        this.inventory = new HashMap<>();
        this.caughtPokemon = new ArrayList<>();
        // Starting items
        inventory.put("Potion", 3);
        inventory.put("Poké Ball", 5);
    }

    // ─── Inventory helpers ──────────────────────────────────────────────────

    public boolean hasItem(String itemName) {
        return inventory.getOrDefault(itemName, 0) > 0;
    }

    public int itemCount(String itemName) {
        return inventory.getOrDefault(itemName, 0);
    }

    public void addItem(String itemName, int qty) {
        inventory.merge(itemName, qty, Integer::sum);
    }

    /** Removes one unit. Returns false if the player has none. */
    public boolean useItem(String itemName) {
        int count = inventory.getOrDefault(itemName, 0);
        if (count <= 0) return false;
        if (count == 1) inventory.remove(itemName);
        else inventory.put(itemName, count - 1);
        return true;
    }

    public boolean spend(int amount) {
        if (money < amount) return false;
        money -= amount;
        return true;
    }

    public void earnMoney(int amount) { money += amount; }

    public void addCaughtPokemon(Pokemon p) { caughtPokemon.add(p); }

    // ─── Getters / Setters ──────────────────────────────────────────────────
    public String getName()                     { return name; }
    public Pokemon getActivePokemon()           { return activePokemon; }
    public void setActivePokemon(Pokemon p)     { this.activePokemon = p; }
    public int getMoney()                       { return money; }
    public Map<String, Integer> getInventory()  { return inventory; }
    public List<Pokemon> getCaughtPokemon()     { return caughtPokemon; }
}