package org.generation.italy.examples.oo.abstraction.exercisegarage;

/*
Mentre mi aspettate fate un esercizio…crate una classe garage
 che gestisce vari tipi di veicoli, con metodi come findvehible,
  park vehicle, payforvehicle, che lavorano in maniera polimorfica sull interfaccia
   vehicle implementata da motorcycle e car
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List; //Interfaccia List che implemenentata da ArrayList

public class Garage {

 private List<Vehicle> vehicles = new LinkedList<>(); //Serve per mantenersi più generale

 public void parkVehicle (Vehicle vehicle){
     vehicle.turnOffEngine();
     vehicles.add(vehicle);
 }


 public boolean findVehicle (String targa){
     for (Vehicle v : vehicles){
         if(v.getPlate().equals(targa)){
             return true;
         }
     }
     return false;
 }

 public List<Vehicle> returnAllVehicles (){
     return List.copyOf(vehicles); //Crea una copia non modificabile della lista (è un metodo di sola lettura)
 }

}
