package org.generation.italy.examples.oo.veicoli2;

public class Main {
    static void main() {
        Garage garage = new Garage();
        Vehicle a1 = new Auto("Lancia", "AF156FG",false);
        a1.parkVehicle();
        garage.addCar();
        a1.findVehicle();
        Vehicle a2 = new Auto("Lamborghini", "ZZ999ZZ",false);
        a2.parkVehicle();
        garage.addCar();
        a2.findVehicle();
        Vehicle m1 = new Motorcicle("Honda", "AB18273",false);
        m1.parkVehicle();
        garage.addCar();
        m1.findVehicle();
        Vehicle m2 = new Motorcicle("Ducati","BB34828",false);
        m2.parkVehicle();
        garage.addCar();
        m2.findVehicle();
    }
}
