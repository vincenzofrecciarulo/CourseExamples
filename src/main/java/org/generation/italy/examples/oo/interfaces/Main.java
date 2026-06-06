package org.generation.italy.examples.oo.interfaces;

public class Main {
    static void main() {
        Vehicle c=new Car();
        c.findVehicle();
        c.drive();
        c.parkVehicle();
        Vehicle m=new Motorcycle();
        m.findVehicle();
        m.drive();
        m.parkVehicle();
    }
}
