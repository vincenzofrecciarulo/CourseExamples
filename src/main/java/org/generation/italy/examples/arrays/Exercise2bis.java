package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise2bis {
    static void main() {
        int[] array = new int[10];

        populateArray(array);
        IO.println(Arrays.toString(array));

        if (hasDuplicates(array)) {
            IO.println("L'array contiene elementi duplicati.");
        } else {
            IO.println("L'array non contiene elementi duplicati.");
        }
    }

    static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10) + 1;
        }
    }

    static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}