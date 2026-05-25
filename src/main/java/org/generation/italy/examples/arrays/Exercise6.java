package org.generation.italy.examples.arrays;

import java.util.Arrays;

import static org.generation.italy.examples.arrays.Exercise2.populateArray;

//dato un array di interi ritorna la moda, il numero che ricorre più spesso
public class Exercise6 {
    static void main() {
        int[]  array= new int[100];

        populateArray(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }
       int modeAndCount[]= findMode(array);
        System.out.println(Arrays.toString(array));
        System.out.println("The mode is: "+ modeAndCount[0]+ " and it appears " + modeAndCount[1]+ " times");

    }
    static int[] findMode(int[] array) {

        int maxCount = 0;
        int mode = array[0];

        for (int i = 0; i < array.length; i++) {

            int count = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mode = array[i];
            }
        }

        return new int[]{mode, maxCount};
    }
}
