package org.generation.italy.examples.manu.esercizio5;

public class Main {
    public static void main(){
        // dipendenti dell'azienda (qui utiliziamo l'upcasting)
        Dipendente d1 = new Dipendente("Luca", 1500);
        Dipendente d2 = new Manager("Anna", 2000, 800);
        Dipendente d3 = new Programmatore("Marco", 1800, 20, 15);

        IO.println(d1.descrizione());
        IO.println(d2.descrizione());
        IO.println(d3.descrizione());
    }
}