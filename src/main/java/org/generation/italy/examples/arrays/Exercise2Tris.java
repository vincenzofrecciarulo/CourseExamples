package org.generation.italy.examples.arrays;

//import static org.generation.italy.examples.arrays.Exercise2Bis.*;

import java.util.Arrays;

public class Exercise2Tris {
    /*
     Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali
     di valore 1-10. Successivamente il programma deve stampare
     gli elementi duplicati.
    */
    void main() {

        int[] intArray = new int[10];

        Exercise2Bis.populateArrayRandIntsZeroTen(intArray);
        System.out.println(Arrays.toString(intArray));

        if (Exercise2Bis.hasDuplicates(intArray)) {
            printDuplicates(intArray);
        } else {
            System.out.println("No duplicates.");
        }

    }

    public static void printDuplicates(int[] inputArray) {

        for (int i = 0; i < inputArray.length - 1; i++) {

            boolean alreadySeen = false;
            for (int k = 0; k < i; k++) {
                if (inputArray[k] == inputArray[i]) {
                    alreadySeen = true;
                    break;
                }
            }

            if (alreadySeen) continue;

            for (int j = i+1; j < inputArray.length; j++) {
                if (inputArray[i] == inputArray[j]) {
                    System.out.print(inputArray[i]);
                    break;
                }
            }
        }

    }

}
