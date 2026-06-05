package org.generation.italy.examples.oo.garage;

import org.generation.italy.examples.oo.garage.interfaces.ParkingObject;

import java.util.ArrayList;

public class Garage implements ParkingObject{
    /*
    Mentre mi aspettate fate un esercizio…crate una classe garage che gestisce
     vari tipi di veicoli, con metodi come findvehible, park vehicle, payforvehicle,
      che lavorano in maniera polimorfica sull interfaccia vehicle implementata da motorcycle e car
     */
    private ArrayList<Vehicle> vehicles = new ArrayList<>();


    public Vehicle findVehicle(String plate){
        for(Vehicle v : vehicles){
            if(v.getLicensePlate().equals(plate)){
                return v;
            }
        }
        return null;
    }



    public void payForVehicle(Vehicle vehicle){

    }

    @Override
    public void park(Vehicle vehicle) {
        vehicle.turnOffEngine();
        vehicles.add(vehicle);
    }
}
