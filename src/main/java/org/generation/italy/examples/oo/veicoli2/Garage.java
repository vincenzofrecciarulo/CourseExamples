package org.generation.italy.examples.oo.veicoli2;

public class Garage {
    private int counterCar = 0;
    private int counterMoto = 0;
    private int counterTot = counterCar + counterMoto;

    public int getCounterCar() {
        return counterCar;
    }

    public int getCounterMoto() {
        return counterMoto;
    }

    public int getCounterTot() {
        return counterTot;
    }
    public void addCar(){
        counterCar++;
    }
    public void addMoto(){
        counterMoto++;
    }
}
