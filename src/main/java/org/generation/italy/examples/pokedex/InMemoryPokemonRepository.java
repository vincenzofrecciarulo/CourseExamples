package org.generation.italy.examples.pokedex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPokemonRepository implements PokemonRepository{
    private Map<Integer, Pokemon> pokemons = new HashMap<>();


    @Override
    public Optional<Pokemon> findById(int id) {
        return Optional.ofNullable(pokemons.get(id));
    }

    @Override
    public List<Pokemon> findAll() {
        return List.of();
    }

    @Override
    public void save(Pokemon pokemon) {
        pokemons.put(pokemon.getId(), pokemon);
    }
}
