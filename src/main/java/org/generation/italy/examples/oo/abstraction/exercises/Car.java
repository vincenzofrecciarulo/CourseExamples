package org.generation.italy.examples.oo.abstraction.exercises;

public class Car implements Vehicle{
    String plate;

    public Car(String plate){
        this.plate=plate;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    @Override
    public double payForVehicle(int hours) {
        double priceForHours = 2.5;
        double total = priceForHours*hours;
        return total;
    }
}
