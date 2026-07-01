package org.generation.italy.examples.oo.abstraction.exercisegarage;

import java.util.Objects;

public class MotorCycle implements Vehicle{

    private double taxPark;
    private String plate;

    public MotorCycle(double taxPark,String targa) {
        this.taxPark = taxPark;
        this.plate = targa;
    }


    @Override
    public double payForVehicle() {
        return taxPark;
    }

    @Override
    public void turnOffEngine() {
        System.out.println("La moto ha spento il motore");
    }

    @Override
    public String getPlate() {
        return plate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MotorCycle that = (MotorCycle) o;
        return Objects.equals(plate, that.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plate);
    }
}
