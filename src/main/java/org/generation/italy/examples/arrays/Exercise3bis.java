package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise3bis {

    static void main() {
        int[] numArray = new int[10];
        populateArray(numArray);
        IO.println(Arrays.toString(numArray));
        invert(numArray);
        IO.println(Arrays.toString(numArray));
    }

    static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 201) - 100;
        }
    }

    public static void invert(int[] numArray) {
        for (int i = 0, j = numArray.length - 1; i < j; i++, j--) {
            swap(numArray, i, j);
        }
    }

    public static void swap(int[] numArray, int i, int j) {
        int temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }
}