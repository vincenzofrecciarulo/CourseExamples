package org.generation.italy.examples.oo.veicoli;

public class Motorcycle implements Vehicles{

    @Override
    public void findVehicle() {
        System.out.println("Il veicolo si trova al piano 2 essendo una moto\n");
    }

    @Override
    public void parkVehicle() {
        System.out.println("il veicolo è stato parcheggiato al 2 piano\n");
    }

    @Override
    public void payForVehicle() {
        System.out.println("sono 40 euro al giorno per la moto\n");
    }
}
