package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise4 {
    /*
    Dato un array di 10 elementi, scrivere una
    funzione che popola l’array con double casuali di valore (0) - (100),
    invocarla sull’array e stamparne la media matematica
     */
    void main() {
        double[] arr = new double[10];
        populateArrayRandDoubles(arr, 0, 100);
        System.out.println(Arrays.toString(arr));
        System.out.println("Avg value is: " + getAverage(arr));
    }

    // includes lower bound, excludes upper bound
    public static void populateArrayRandDoubles(double[] array, double min, double max) {
        for (int i = 0; i<array.length; i++) {
            array[i] = (Math.random() * (max - min)) + min;
        }
    }

    public static double getAverage(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum/numbers.length;
    }
}
