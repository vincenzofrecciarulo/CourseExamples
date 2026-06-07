package org.generation.italy.examples.oo.mudPersonale.items;

import org.generation.italy.examples.oo.mudPersonale.entities.Player;

public class Pokeball extends Item{
    private static final String NAME = "Pokeball";
    private static final int PRICE = 5;
    private static final double WEIGHT = 10.0;
    private int captureChance = 5;

    public Pokeball() {
        super(Pokeball.WEIGHT, Pokeball.PRICE, Pokeball.NAME);
    }

    @Override
    public void interact(Player player) {
        IO.println("Questo è un pokeball...");
    }


}
