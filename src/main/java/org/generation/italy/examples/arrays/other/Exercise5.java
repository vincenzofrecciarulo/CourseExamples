package org.generation.italy.examples.arrays.other;

// Dato un array di 10 elementi di qualunque tipo, invertire l’ordine degli elementi

public class Exercise5 {
    static void main(){
        int[] numArray = {1,2,3,4,5,6,7,8,9,10};

        // Inversione array
        for (int i = 0; i < numArray.length / 2; i++) {

            int temp = numArray[i];

            numArray[i] = numArray[numArray.length - 1 - i];


            numArray[numArray.length - 1 - i] = temp;
        }

        // Stampa array invertito
        for (int i = 0; i < numArray.length; i++) {

            System.out.print(numArray[i] + " ");
        }
    }
}
