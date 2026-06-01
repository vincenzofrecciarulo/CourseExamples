package org.generation.italy.examples.manu.esercizio4;

// Crea una classe derivata Automobile con:
// - numeroPorte
//
// Modifica la "descrizione" affinché mostri anche il numero di porte

public class Automobile extends Veicolo{
    private int numOfDoors; // numero delle portiere dell'auto

    public Automobile(String brand, int year, int numOfDoors) {
        super(brand, year);
        this.numOfDoors = numOfDoors;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    // ora modifichiamo il metodo "descrizione" presente nella classe Automobile
    @Override
    public String descrizione(){
        return super.descrizione() + ", numero di portiere: " + this.numOfDoors;
    }
}