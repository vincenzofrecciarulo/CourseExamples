package org.generation.italy.examples.arrays;

import java.util.Arrays;

// scrivere funzione che popola array con numeri interi casuali da 1 a 10
// Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10. Successivamente il programma deve stampare un messaggio per l’utente dicendo se nell’array ci sono elementi duplicati o no

public class Exercise2 {
    static void main() {
        int[] array = new int[10];

        populateArray(array);
        IO.println(Arrays.toString(array));
        duplicateControl(array);
    }

    static void populateArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int num =  (int) (Math.random() * 10) + 1;
            array[i] = num;

        }

    }

    static void duplicateControl(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(control(arr, arr[i], i)){
                // System.out.println("duplicato: " + arr[i]);
                System.out.println("Esistono elementi duplicati" );
                break;
            }
        }
    }

    static boolean control(int[] arr, int number, int index){
        for(int i = 0; i < arr.length; i++){
            if(number == arr[i] && index != i){
                return true;
            }

        }
    return false;
    }


}
