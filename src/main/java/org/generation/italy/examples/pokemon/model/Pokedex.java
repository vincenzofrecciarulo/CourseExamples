package org.generation.italy.examples.pokemon.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Pokedex {
    private final Map<Integer, PokedexEntry> byNumber = new HashMap<>();
    private final Map<String, PokedexEntry> byName = new HashMap<>();

    public void register(PokedexEntry entry) {
        byNumber.put(entry.getNumber(), entry);
        byName.put(entry.getName().toLowerCase(), entry);
    }

    public PokedexEntry getByNumber(int number) {
        return byNumber.get(number);
    }

    public PokedexEntry getByName(String name) {
        return byName.get(name.toLowerCase().trim());
    }

    public Collection<PokedexEntry> all() {
        return byNumber.values();
    }

    public int size() { return byNumber.size(); }
}