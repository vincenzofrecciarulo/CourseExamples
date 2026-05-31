package org.generation.italy.examples.Exercises.Exercise1.Objects.ereditaryCar;

public class Vehicle {
    /*
    4. Veicolo e Automobile (Prima ereditarietà)
Crea una classe base Veicolo con:
marca
anno
Metodo:
descrizione()
Crea una classe derivata Automobile con:
numeroPorte
Modifica la descrizione affinché mostri anche il numero di porte.
Obiettivo
Praticare:
ereditarietà
riutilizzo del codice
     */
    private String brand;
    private int year;

    public Vehicle(String brand, int year){
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public void description(){
        IO.println("la " + brand + " è un veicolo del " + year);

    }
}
