package org.generation.italy.examples.oo.homeexercise.ex11;

public abstract class Animale {

    protected String name;
    protected Habitat habitats;

    public Animale(String name,Habitat habitats) {
        this.name = name;
        this.habitats= habitats;

    }

    public abstract void descriviAmbiente();
}
