package org.generation.italy.examples.pokedex;

import java.util.*;

public interface PokemonRepository {
    Optional<Pokemon> findById(int id);
    List<Pokemon> findAll();
    void save(Pokemon pokemon);
}
