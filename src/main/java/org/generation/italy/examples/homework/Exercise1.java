package org.generation.italy.examples.homework;

public class Exercise1 {
    //1)Scrivi una funzione main che crea due variabili intere , poi una che rappresenta la somma delle due e stampa il risultato.

    void main(){
        IO.println("Inserisci un numero: ");
        int num1 = Integer.parseInt(IO.readln());
        IO.println("Inserisci un numero: ");
        int num2 = Integer.parseInt(IO.readln());
        int sum = num1 + num2;

        IO.println("La somma è " + sum);
    }
}
