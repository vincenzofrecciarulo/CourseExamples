package org.generation.italy.examples.oo.abstraction.exercisegarage;

import java.util.Objects;

public class Car implements Vehicle{

    private double taxPark;
    private String plate;


    public Car(double taxPark,String plate) {
        this.taxPark = taxPark;
        this.plate = plate;
    }


    @Override
    public double payForVehicle() {
        return taxPark;
    }

    @Override
    public void turnOffEngine() {
        System.out.println("La macchina ha spento il motore");
    }

    @Override
    public String getPlate() {
        return plate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(plate, car.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plate);
    }
}
