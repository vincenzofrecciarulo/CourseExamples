package org.generation.italy.examples.oo.veicoli2;

public class Motorcicle extends Vehicle{
    public Motorcicle(String model, String plate, boolean isParked) {
        super(model, plate, isParked);
    }

    @Override
    public void findVehicle() {
        if (this.getParked()) {
            System.out.printf("la tua %s si trova al secondo piano essendo una moto%n", getModel());
        }
    }

    @Override
    public void parkVehicle() {
        setParked(true);
        payForVehicle();
    }

    @Override
    public void payForVehicle() {
        System.out.println("paga 40 euro per la moto, poveraccio\n");
    }
}
