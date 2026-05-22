package org.generation.italy.examples.arrays;

import java.util.Arrays;
// Ex3Bis (solitaria)
// Rifarlo ma con valori (-100) - (+100)
public class Exercise3Bis {
    static void main() {
        int[] numbers = new int[10];
        populateArray(numbers);
        IO.println(Arrays.toString(numbers));
    }
    public static void populateArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()* (100 -(-100)+1))+(-100);
        }
        IO.println(findMaxAndMinNumbers(arr));
    }

    public static String findMaxAndMinNumbers(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (max < arr[i] ){
                max = arr[i];
            } else if (min >= arr[i]){
                min = arr[i];
            }
        }
        return "max: " + max + " min: " + min;
    }
}
