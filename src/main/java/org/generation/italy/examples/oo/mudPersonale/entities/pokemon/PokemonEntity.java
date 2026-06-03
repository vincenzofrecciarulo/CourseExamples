package org.generation.italy.examples.oo.mudPersonale.entities.pokemon;

import org.generation.italy.examples.oo.mudPersonale.Helper;
import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.enums.Nature;
import org.generation.italy.examples.oo.mudPersonale.enums.Pokemon;


public class PokemonEntity extends Entity {
    private Nature nature;
    private PokemonStat pokemonStat;
    private int level;
    private int currentHp;

    public PokemonEntity(Pokemon pokemon, int level) {
        super(pokemon.getName());
        this.nature = getRandomNature();
        this.level = level;
        this.pokemonStat = pokemon.getPokemonStat();
        currentHp = pokemonStat.getHp(level);
    }

    public boolean heal(int healAmount){
        if(currentHp >= pokemonStat.getHp(level)){
            return false;
        }
        currentHp += healAmount;

        if(currentHp> pokemonStat.getHp(level)){
            currentHp = pokemonStat.getHp(level);
        }
        return true;
    }

    public void healMax(){
        currentHp += pokemonStat.getHp(level);
    }

    public void showStats(){
        System.out.printf("""
                %s
                Nature: %s
                Current HP: %s
                Max HP: %s
                Attack: %s
                Special attack: %s
                Defense: %s
                Special defense: %s
                Speed: %s
                """,
                getName(),
                nature,
                currentHp,
                pokemonStat.getHp(level),
                pokemonStat.getAttack(level),
                pokemonStat.getSpecialAttack(level),
                pokemonStat.getDefense(level),
                pokemonStat.getSpecialDefense(level),
                pokemonStat.getSpeed(level));
    }

    public Nature getRandomNature(){
        int num = Helper.getRandomNumber(Nature.values().length);
        return Nature.values()[num];
    }

    public static PokemonEntity getRandomPokemon(int areaMinLevel, int areaMaxLevel){
        int randomNum = Helper.getRandomNumber(Pokemon.values().length);
        Pokemon pokemon = Pokemon.values()[randomNum];
        int level = Helper.getRandomNumber(areaMaxLevel, areaMinLevel);
        return new PokemonEntity(pokemon, level);
    }
}
