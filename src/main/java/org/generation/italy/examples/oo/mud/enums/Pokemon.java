package org.generation.italy.examples.oo.mud.enums;

import org.generation.italy.examples.oo.mud.entities.pokemon.PokemonStat;

public enum Pokemon {
    PIKACHU("Pikachu", new PokemonStat(25, 10, 16, 8,
            10, 15, 3, 1.6f, 2.1f, 1.2f, 1.5f, 1.7f)),
    PICHU("Pichu", new PokemonStat(15, 5, 7, 4, 7, 9,
            2.4f, 1.4f, 1.9f, 1f, 1.3f, 1.4f));


    private final String name;
    private final PokemonStat pokemonStat;

    Pokemon(String name, PokemonStat pokemonStat){
        this.name = name;
        this.pokemonStat = pokemonStat;
    }

    public String getName(){
        return name;
    }

    public PokemonStat getPokemonStat(){
        return pokemonStat;
    }


}
