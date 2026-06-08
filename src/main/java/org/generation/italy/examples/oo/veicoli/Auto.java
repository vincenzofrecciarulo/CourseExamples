package org.generation.italy.examples.oo.veicoli;

import java.time.LocalDate;

public class Auto implements Vehicles{

    @Override
    public void findVehicle() {
        System.out.println("Il veicolo è al piano 1 essendo una macchina\n");
    }

    @Override
    public void parkVehicle() {
        System.out.println("Veicolo parcheggiato al piano 1\n");
    }

    @Override
    public void payForVehicle() {
        System.out.println("per la macchina sono 60 euro al giorno\n");
    }

}
