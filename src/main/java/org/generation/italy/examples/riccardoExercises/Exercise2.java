package org.generation.italy.examples.riccardoExercises;

public class Exercise2 {
    static void main() {
        //level 2
        /*
         Scrivi una main che crea due variabili intere e le passa a una funzione che
         riceve questi due valori e ritorna la loro somma. La main stampera' il risultato..*/


        int a = 15;
        int b = 17;
        int c = sumInt(a,b);
        System.out.println("Somma = "+c);

    } public static int sumInt (int a , int b){

        return  a + b;
    }


}
