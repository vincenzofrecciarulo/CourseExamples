package org.generation.italy.examples.moreexercises.ex03;

public abstract class Veicolo{
    protected int velocity;

    public Veicolo(int velocity) {
        this.velocity = velocity;
    }

    public int getVelocity() {
        return velocity;
    }

    public abstract void accelera();
    public abstract void frena();

}