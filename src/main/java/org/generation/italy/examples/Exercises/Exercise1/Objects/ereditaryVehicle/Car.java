package org.generation.italy.examples.Exercises.Exercise1.Objects.ereditaryVehicle;

public class Car extends Vehicle{
    private int seats;

    public Car(String brand, int maxSpeed, int seats){
        super(brand, maxSpeed);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public void describe(){
        IO.println("Questa macchina è una " + getBrand() + " ed ha " + getSeats() + " posti. La sua velocità massima è di " + getMaxSpeed() + " km/h");
    }
}
