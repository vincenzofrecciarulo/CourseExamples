package org.generation.italy.examples.manu.esercizio4;

// Crea una classe Veicolo con:
// - marca;
// - anno
//
// Metodo:
// descrizione()

public class Veicolo {
    private String brand; // marca dell'auto
    private int year;     // anno di uscita

    public Veicolo(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String descrizione(){
        return "Marca del veicolo: " + this.brand + ", anno d'uscita: " + this.year;
    }
}