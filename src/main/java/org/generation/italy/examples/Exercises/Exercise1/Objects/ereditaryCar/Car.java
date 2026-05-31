package org.generation.italy.examples.Exercises.Exercise1.Objects.ereditaryCar;

public class Car extends Vehicle{
    private int doorNumber;

    public Car(String brand, int year, int doorNumber){
        super(brand, year);
        this.doorNumber = doorNumber;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    @Override
    public void description(){
        IO.println("la " + getBrand() + " è un veicolo del " + getYear() + " ed ha " + getDoorNumber() + " porte");

    }

    static void main() {
        Car car1 = new Car("Ferrari", 2020, 4);
        car1.description();
    }
}
