package org.generation.italy.examples.pausa;

public class Main {
    public static void main() {

        Garage garage = new Garage();

        Vehicle car = new Car("AB123CD");
        Vehicle moto = new Motorcycle("XY999ZZ");

        garage.parkVehicle(car);
        garage.parkVehicle(moto);

        System.out.println(garage.findVehicle("AB123CD"));

        double payment = garage.payForVehicle("XY999ZZ", 5);

        System.out.println("Pagamento: " + payment);
    }
}