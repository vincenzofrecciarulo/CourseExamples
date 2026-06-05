package org.generation.italy.examples.pausa;

public class Motorcycle implements Vehicle{

    private String plate;

    // Qui creiamo il costruttore
    public Motorcycle(String plate) {
        this.plate = plate;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    // 1 euro all'ora per il noleggio della moto
    @Override
    public double calculatePayment(int hours) {
        return hours * 1;
    }

    @Override
    public String toString() {
        return "Motorcycle: " + plate;
    }
}