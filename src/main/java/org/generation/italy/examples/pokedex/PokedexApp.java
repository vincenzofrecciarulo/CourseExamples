package org.generation.italy.examples.pokedex;

import java.util.List;

public class PokedexApp {
    static void main() {
        InMemoryPokemonRepository pokedex = new InMemoryPokemonRepository();
        pokedex.save(new Pokemon(1,"Charmender","fuoco", 20));
        pokedex.save(new Pokemon(2,"Bulbasaur","erba", 20));
        pokedex.save(new Pokemon(3,"Squirtle","acqua", 20));
        pokedex.save(new Pokemon(4,"Piplup","acqua", 20));
        pokedex.save(new Pokemon(5,"Chimchar","fire", 20));
        pokedex.save(new Pokemon(6,"Turtwig","erba", 20));

        String keyID;
        keyID = IO.readln("inserisci id pokemon");
        int key;
        try {
            key = Integer.parseInt(keyID);
            Pokemon p = pokedex.findById(key);
            System.out.println(p);
        } catch (NumberFormatException e) {
            System.out.println("ID non valido: devi inserire un numero");
        } catch (PokemonNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Ricerca completata.");
        }
        printAll(pokedex.findAll());
    }
    private static void printAll(List<Pokemon> pokemons){
        for (Pokemon p : pokemons){
            System.out.println(p);
        }
    }
}
