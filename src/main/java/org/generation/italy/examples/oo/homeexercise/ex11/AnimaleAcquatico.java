package org.generation.italy.examples.oo.homeexercise.ex11;

public abstract class AnimaleAcquatico extends Animale{

    protected double profondità;

    public AnimaleAcquatico(String name, double profondità, Habitat habitats) {
        super(name, habitats);
        this.profondità=profondità;
    }
}
