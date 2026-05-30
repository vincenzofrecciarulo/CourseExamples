package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise2tris {
    static void main() {
        int[] array = new int[10];

        populateArray(array);
        IO.println(Arrays.toString(array));

        printDuplicates(array);
    }

    static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10) + 1;
        }
    }

    static void printDuplicates(int[] array) {
        boolean foundAny = false;

        for (int i = 0; i < array.length; i++) {
            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {
                if (array[k] == array[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (!alreadyPrinted) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        IO.println("Duplicato trovato: " + array[i]);
                        foundAny = true;
                        break;
                    }
                }
            }
        }

        if (!foundAny) {
            IO.println("Nessun duplicato trovato.");
        }
    }
}