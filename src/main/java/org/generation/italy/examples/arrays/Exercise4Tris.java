package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Ex4Tris (solitaria)
Popolare l’array e stamparne solo gli elementi che distano più di 10 dalla media di tutto l’array
 */
public class Exercise4Tris {
    static void main() {
        int[] numbers = new int[10];
        populateArray(numbers);
        IO.println(Arrays.toString(numbers));
        int average = findAverage(numbers);
        IO.println("Average: " + average);
        printMustTenOfAverage(numbers,average);
    }

    public static void populateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 100) + 1;
        }
    }

    public static int findAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void printMustTenOfAverage(int[] arr, int av){
        for (int i = 0; i < arr.length; i++){
            if (av + 10 < arr[i]){
                IO.println(arr[i]);
            }
        }
    }
}
