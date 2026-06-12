package org.generation.italy.examples.moreexercises.ex03;

public class Moto extends Veicolo{
    public Moto(int velocity) {
        super(velocity);
    }

    @Override
    public void frena() {
        velocity = 0;
        System.out.println("Ora la velocità della moto è di (km/h): " + velocity);
    }

    @Override
    public void accelera() {
        velocity += 5 ;
        System.out.println("Ora la velocità della moto è di (km/h): " + velocity);
    }
}
