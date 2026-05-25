package org.generation.italy.examples.arrays;

import java.util.Arrays;

//Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali
//di valore (1) - (100), invocarla sull’array e stampare il valore massimo e il valore minimo
public class Exercise3 {
    public static void main(String[]args) {
        int[]  array= new int[10];

        populateArray(array);
        IO.println(Arrays.toString(array));
        int max = findMax(array);
        int min = findMin(array);

        System.out.println("Valore massimo: " + max);
        System.out.println("Valore minimo: " + min);
    }



    static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
        }
    }
    static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
    static int findMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
    }



