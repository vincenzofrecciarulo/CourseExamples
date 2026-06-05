package org.generation.italy.examples.pausa;

import java.util.ArrayList;

public class Garage {

    // garage deve essere solo un contenitore di veicoli
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    // parcheggia veicolo
    public void parkVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // cerca veicolo tramite la targa
    public Vehicle findVehicle(String plate) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getPlate().equals(plate)) {
                return vehicle;
            }
        }

        return null;
    }

    // pagamento
    public double payForVehicle(String plate, int hours) {

        Vehicle vehicle = findVehicle(plate);

        if (vehicle != null) {
            return vehicle.calculatePayment(hours);
        }

        return 0;
    }
}