package org.generation.italy.examples.oo.veicoli2;

public abstract class Vehicle {
    private String model;
    private String plate;
    private boolean isParked;

    public Vehicle(String model, String plate, boolean isParked) {
        this.model = model;
        this.plate = plate;
        this.isParked = isParked;
    }

    public abstract void findVehicle();

    public abstract void parkVehicle();

    public abstract void payForVehicle();

    public String getModel() {
        return model;
    }

    public boolean getParked() {
        return isParked;
    }

    public String getPlate() {
        return plate;
    }

    public void setParked(boolean parked) {
        isParked = parked;
    }
}
