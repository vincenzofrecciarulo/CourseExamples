package org.generation.italy.examples.arrays;

import java.util.Arrays;
/*
Ex4
Dato un array di 10 elementi,
scrivere una funzione che popola l’array con double casuali di valore (0) - (100),
invocarla sull’array e stamparne la media matematica
 */
public class Exercise4 {
    static void main() {
        double[] numbers = new double[5];
        populateRandomDoubleArrayAndFindAverage(numbers);
        IO.println(Arrays.toString(numbers));
    }

    private static void populateRandomDoubleArrayAndFindAverage(double[] arr) {
        double sum = 0;
        for (int i = 0; i< arr.length; i++){
            arr[i] = Math.random() * 100;
            IO.println(arr[i]);
            sum += arr[i];
        }
        IO.println("Average of array: " + sum / arr.length);
    }
}
