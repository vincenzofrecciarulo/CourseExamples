package org.generation.italy.examples.arrays;


import java.util.Arrays;

public class Exercise2Bis {
    /*
    Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
    Successivamente il programma deve stampare un messaggio per l’utente dicendo se nell’array ci sono elementi duplicati o no
    */
    void main() {
        int[] array = new int[10];
        populateArrayRandIntsZeroTen(array);
        System.out.println(Arrays.toString(array));
        if (hasDuplicates(array)) {
            System.out.println("The array had duplicate numbers.");
        } else {
            System.out.println("The array only has unique numbers.");
        }
    }


    public static void populateArrayRandIntsZeroTen(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            arr[i] = (int)(Math.random() * 10) + 1;
        }
    }

    public static boolean hasDuplicates(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    }
