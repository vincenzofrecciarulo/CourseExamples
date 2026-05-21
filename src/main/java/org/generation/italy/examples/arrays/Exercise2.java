package org.generation.italy.examples.arrays;
import java.util.Arrays;

public class Exercise2 {
    // given an array of integers, write a method that fills it
    // with random integers in the range 0-10
    void main() {
        int[] array = new int[10]; // fills with 10 zeroes
        populateArray(array);
        IO.println(Arrays.toString(array));
    }

    static void populateArray(int[] inArray) {
        for (int i=0; i<inArray.length; i++) {
            // Math.random() generates from 0.0 inclusive to 1.0 exclusive. 0.0 - 0.99
            // we multiply * 10 cause by only casting, we would only have 0! cause of truncation
            // +1 inside the parentheses would have worked, but we'd have one more casting operation
            // so it's better to write it outside.
            inArray[i] = (int)(Math.random() * 10) + 1;
        }
    }
}
