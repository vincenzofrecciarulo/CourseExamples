package org.generation.italy.examples.oo.interfaces;

public class Motorcycle implements Vehicle{
    @Override
    public void drive() {
        IO.println("Mi sembro IL DOC");
    }

    @Override
    public void parkVehicle() {
        IO.println("Sono riuscito ad incastrarla tra due macchine");

    }

    @Override
    public void findVehicle() {
        IO.println("Menomale l'ho messa sul marciapiede");

    }
    @Override
    public void payForVehicle(){
        IO.println("Madonna costa poco questa moto");
    }
}
