package org.generation.italy.examples.arrays;

/*
Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore (1) - (100),
 invocarla sull’array e stampare il valore massimo e il valore minimo

*/

import java.util.Arrays;

public class Exercise6 {

    static void main() {


        int[] numbers = new int[10];

        populateArray(numbers);
        IO.println(Arrays.toString(numbers));
        int max = calculateMax(numbers);
        System.out.println("Max = "+max);

        int min = calculateMin(numbers);
        System.out.println("Min = "+min);

    }



    public static void populateArray(int[] numbers){
        for (int i = 0; i< numbers.length;i++){
            numbers[i] = (int) ((Math.random()*100)+1);
        }
    }

    public static int calculateMax (int[] numbers){
        int max = numbers[0];
        for (int i =1;i<numbers.length;i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        return max;
    }

    public static int calculateMin (int[] numbers){
        int min = numbers[0];
        for (int i =1;i<numbers.length;i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }



}
