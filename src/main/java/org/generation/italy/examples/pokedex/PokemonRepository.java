package org.generation.italy.examples.pokedex;

import java.util.*;

public interface PokemonRepository {
    Pokemon findById(int id) throws PokemonNotFoundException;
    List<Pokemon> findAll();
    void save(Pokemon pokemon);
}
