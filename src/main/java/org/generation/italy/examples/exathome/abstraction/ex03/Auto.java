package org.generation.italy.examples.exathome.abstraction.ex03;

public class Auto extends Veicolo{

    public Auto(int velocity) {
        super(velocity);
    }

    @Override
    public void frena() {
        velocity = 0;
        System.out.println("Ora la velocità dell'auto è di (km/h): " + velocity);
    }

    @Override
    public void accelera() {
        velocity += 10 ;
        System.out.println("Ora la velocità dell'auto è di (km/h): " + velocity);
    }
}