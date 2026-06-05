package org.generation.italy.examples.oo.mudPersonale.rooms;

import org.generation.italy.examples.oo.mudPersonale.entities.Entity;
import org.generation.italy.examples.oo.mudPersonale.entities.pokemon.PokemonEntity;
import org.generation.italy.examples.oo.mudPersonale.items.Item;


public class DangerRoom extends Room{
    private static final String TITLE = "Erba Alta";
    private static final String DESCRIPTION = "Qui risiedono mostri pericolosi";
    private static final String MAP_ICON = "D";

    public DangerRoom() {
        super(DangerRoom.TITLE, DangerRoom.DESCRIPTION, DangerRoom.MAP_ICON);
    }

    @Override
    protected Entity getRandomNpc(){
        return PokemonEntity.getRandomPokemon(5,10);
    }

    @Override
    protected Item getRandomItem() {
        return null;
    }
}
