package org.generation.italy.examples.pokedex;

public class PokemonNotFoundException extends Exception{
    public PokemonNotFoundException(int id) {
        super("Pokémon con id " + id + " non trovato");
    }
}
