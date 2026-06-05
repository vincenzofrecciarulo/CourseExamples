package org.generation.italy.examples.oo.veicoli2;

public class Auto extends Vehicle{
    public Auto(String model, String plate, boolean isParked) {
        super(model, plate, isParked);
    }

    @Override
    public void findVehicle() {
        if (this.getParked()) {
            System.out.printf("la tua %s si trova al pirmo piano essendo una macchina%n", getModel());
        }
    }

    @Override
    public void parkVehicle() {
        setParked(true);

        payForVehicle();
    }

    @Override
    public void payForVehicle() {
        System.out.println("paga 60 euro, poveraccio\n");
    }

}
