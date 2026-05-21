package org.generation.italy.examples.arrays.aula;
/* dato un array di 10 elementi di qualsiasi tipo, invertire l'ordine degli elementi*/


public class Exercise1 {
    static void main() {
        int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] temp = new int[ numArray.length];

        for (int i = 0; i< numArray.length ; i++){
            temp[ numArray.length-1-i] =   numArray[i];
        }

        System.out.println("\nL'indirizzo dell'array temporaneo è: \n" + temp + "\nL'indirizzo dell'array originale è: \n" + numArray);
        System.out.println("\nEcco il risultato dell'esercizio:");
        printArray(temp);
    }

    static void printArray(int [] array) {
        for (int x : array) {
            System.out.println(x);
        }

        /* for (int i = 0; i<a.length ; i++){
            System.out.println(a[i]);
        } */
    }

}
