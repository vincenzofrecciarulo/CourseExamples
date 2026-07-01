package org.generation.italy.examples.oo.veicoli;

public class Garage {
    static void main() {
        Vehicles a = new Auto();
        Vehicles s = new Motorcycle();
        a.parkVehicle();
        a.payForVehicle();
        a.findVehicle();
        s.parkVehicle();
        s.payForVehicle();
        s.findVehicle();
    }
}
