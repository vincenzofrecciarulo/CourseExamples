package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise7 {

    static void main() {

        int[] numbers = new int[10];
        populateArray(numbers);
        System.out.println(Arrays.toString(numbers));
        int max = calculateMax(numbers);
        System.out.println("Max = "+max);

        int min = calculateMin(numbers);
        System.out.println("Min = "+min);


    }

    public static void populateArray(int[] numbers){
        for (int i = 0; i< numbers.length;i++){
            numbers[i] = (int)(Math.random() * (100 - (-100) + 1)) -100;
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
