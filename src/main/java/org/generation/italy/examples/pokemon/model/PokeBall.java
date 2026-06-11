package org.generation.italy.examples.pokemon.model;

public class PokeBall extends Item {
    private final double catchMultiplier;

    public PokeBall() {
        super("Poké Ball", "Used to catch wild Pokémon", 200);
        this.catchMultiplier = 1.0;
    }

    /** PokéBall is not directly usable as a healing item — see CatchService. */
    @Override
    public boolean use(Pokemon pokemon) {
        System.out.println("Throw the Poké Ball at a wild Pokémon first!");
        return false;
    }

    public double getCatchMultiplier() { return catchMultiplier; }
}