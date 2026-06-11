package org.generation.italy.examples.pokedex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPokemonRepository implements PokemonRepository{
    private Map<Integer, Pokemon> pokemons = new HashMap<>();


    @Override
    public Pokemon findById(int id) throws PokemonNotFoundException {
        Pokemon pokemon = pokemons.get(id);
        if (pokemon == null){
            throw new PokemonNotFoundException(id);
        }
        return pokemon;
    }

    @Override
    public List<Pokemon> findAll() {
        return new ArrayList<>(pokemons.values());
    }

    @Override
    public void save(Pokemon pokemon) {
        pokemons.put(pokemon.getId(), pokemon);
    }
}
