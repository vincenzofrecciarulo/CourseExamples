package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise3Bis {
    /*
    Dato un array di 10 elementi, scrivere una funzione che popola l’array
    con numeri interi casuali di valore (-100) - (100),
    invocarla sull’array e stampare il valore massimo e il valore minimo
    */
    void main() {
        int[] array = new int[10];
        populateArrayRandInts(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Max value is: " + findMax(array));
        System.out.println("Min value is: " + findMin(array));
    }

    public static void populateArrayRandInts(int[] array) {
        for (int i=0; i<array.length; i++) {
            array[i] = (int)(Math.random() * 201) - 100;
        }
    }

    public static int findMax(int[] numbers) {
        int max = numbers[0];
        for (int i=1; i<numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int findMin(int[] numbers) {
        int min = numbers[0];
        for (int i=1; i< numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
}
