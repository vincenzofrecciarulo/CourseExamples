package org.generation.italy.examples.oo.mudPersonale.rooms;

import org.generation.italy.examples.oo.mudPersonale.Helper;
import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.pokemon.PokemonEntity;
import org.generation.italy.examples.oo.mudPersonale.enums.Pokemon;
import org.generation.italy.examples.oo.mudPersonale.items.Item;

import java.util.ArrayList;
import java.util.Random;


public class DangerRoom extends Room{
    private static final String TITLE = "Erba Alta";
    private static final String DESCRIPTION = "Qui risiedono mostri pericolosi";
    private static final String MAP_ICON = "D";

    public DangerRoom() {
        super(DangerRoom.TITLE, DangerRoom.DESCRIPTION, DangerRoom.MAP_ICON);
    }

    @Override
    protected ArrayList<Entity> spawnEntities(){
        int randomNum = Helper.getRandomNumber(4, 1);
        ArrayList<Entity> entities = new ArrayList<>();
        for(int i = 0; i < randomNum; i++){
            entities.add(PokemonEntity.getRandomPokemon(5, 10));
        }
        return entities;
    }


}
