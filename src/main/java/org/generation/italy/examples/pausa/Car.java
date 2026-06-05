package org.generation.italy.examples.pausa;

public class Car implements Vehicle{

    private String plate;

    // Qui creiamo il costruttore
    public Car(String plate) {
        this.plate = plate;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    // 2 euro all'ora per il noleggio dell'auto
    @Override
    public double calculatePayment(int hours) {
        return hours * 2;
    }

    @Override
    public String toString() {
        return "Car: " + plate;
    }
}