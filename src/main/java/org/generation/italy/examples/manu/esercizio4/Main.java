package org.generation.italy.examples.manu.esercizio4;

public class Main {
    public static void main(String[] args) {
        // qui creiamo e stampiamo un oggetto che appartiene solo alla classe Veicolo
        Veicolo v = new Veicolo("Fiat", 2010);
        IO.println(v.descrizione());

        // qui creiamo e stampiamo un oggetto che appartiene alla classe Automobile
        Automobile a = new Automobile("BMW", 2022, 4);
        IO.println(a.descrizione());
    }
}