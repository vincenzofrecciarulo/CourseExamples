package org.generation.italy.examples.Exercises.Exercise1.Objects.ereditaryVehicle;

public class Start {
    static void main() {
        Car car = new Car("Ferrari", 350, 4);
        Bike bike = new Bike("Honda", 320, true);
        car.describe();
        IO.println();
        bike.describe();
    }

}
