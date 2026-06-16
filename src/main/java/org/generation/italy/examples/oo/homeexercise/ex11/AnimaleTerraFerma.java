package org.generation.italy.examples.oo.homeexercise.ex11;

public abstract class AnimaleTerraFerma extends Animale {

    protected int zampe;

    public AnimaleTerraFerma(String name, int zampe, Habitat habitats) {
        super(name, habitats);
        this.zampe= zampe;
    }
}
