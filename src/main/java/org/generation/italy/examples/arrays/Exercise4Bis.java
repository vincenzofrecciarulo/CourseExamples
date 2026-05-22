package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Ex4Bis (solitaria)
Rifarlo ma calcolando la media senza il valore massimo e il valore minimo
 */
public class Exercise4Bis {
    static void main() {
        double[] numbers = new double[5];
        populateRandomDoubleArray(numbers);
        IO.println(Arrays.toString(numbers));
    }

    private static void populateRandomDoubleArray(double[] arr) {
        for (int i = 0; i< arr.length; i++){
            arr[i] = Math.random() * 100;
            IO.println(arr[i]);
        }
            findAverageWithoutMaxAndMin(arr);
    }

    private static void findAverageWithoutMaxAndMin(double[] arr) {
        double sum = 0;
        double max = arr[0];
        double min = arr[0];
        for (int i = 0; i < arr.length; i ++){
            sum += arr[i];
            if(max < arr[i]){
            max = arr[i];
            }else if (min >= arr[i]){
                min = arr[i];
            }
        }
        double averageWithoutMaxAndMin = (sum - max - min) / (arr.length - 2);
        IO.println("average without max and min: " + averageWithoutMaxAndMin);
    }
}
