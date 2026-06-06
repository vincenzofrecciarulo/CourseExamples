package org.generation.italy.examples.oo.interfaces;

public class Car implements Vehicle{

    @Override
    public void drive() {
        IO.println("Adesso do gas fino a schiantarmi");
    }

    @Override
    public void parkVehicle() {
        IO.println("Parcheggio,speriamo di non graffiarla");
    }

    @Override
    public void findVehicle() {
        IO.println("DOVE CAZ L'HO MESSA");
    }
    @Override
    public void payForVehicle(){
        IO.println("Pagata troppo è anche schilometrata");
    }
}
