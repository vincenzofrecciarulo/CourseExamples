package org.generation.italy.examples.oo.abstraction.exercisegarage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {
        Garage g = new Garage();
        Vehicle ducati = new MotorCycle(12.90,"fake123");
        Vehicle bmw = new Car(13.99,"fake12345");
        g.parkVehicle(ducati);
        g.parkVehicle(bmw);

        g.findVehicle("fake123");
        g.findVehicle("fake12345");
        g.findVehicle("ciccio123");
        List<Vehicle> vs = g.returnAllVehicles();

        for (Vehicle v : vs){
            System.out.println(v.getPlate());
        }

    }

}
