package org.generation.italy.examples.homework;

public class Exercise2 {
    /*
    2)Scrivi una main che crea due variabili intere e le passa a una funzione che
    riceve questi due valori e ritorna la loro somma. La main stampera' il risultato.
     */
    static void main(){
        int num1 = 2;
        int num2 = 4;
        int sum = sum(num1, num2);
        IO.println("La somma tra 2 e 4 è " + sum);
    }

    static int sum(int num1, int num2){
        return  num1 + num2;
    }
}
