package org.generation.italy.examples.arrays.casa;


import java.util.Arrays;

// Ex.2:
// Scrivere una funzione che popola un array con numeri interi casuali di valore 1-10

// Ex.2Bis:
// Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10. Successivamente il programma deve stampare un messaggio per l’utente dicendo se nell’array ci sono elementi duplicati o no

// Ex.2Tris:
// Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10. Successivamente il programma deve stampare gli elementi duplicati

public class Ex2 {
    public static void main(String[] args){
        int[]  array= new int[10];

        populateArray(array);

        IO.println(Arrays.toString(array));

        if (hasDuplicates(array)) {
            System.out.println("Trovati i duplicati!");
        } else {
            System.out.println("Nessun numero duplicato.");
        }

        printDuplicates(array);
    }

    public static void populateArray(int[] array) {
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*10)+1;
        }
    }

    public static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    static void printDuplicates(int[] array) {
        System.out.print("I numeri duplicati sono: ");

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] == array[j]) {
                    System.out.print(array[i] + " ");
                    break;
                }
            }
        }

        System.out.println("\n");
    }
}