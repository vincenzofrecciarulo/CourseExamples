package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise3Lezione {
    // scriviamo una funzione che riceve in input un array e lo inverte
    // direttamente, senza creare array temporanei
    void main() {
        int[] numArray = {1, 3, 2, 6, 8, 9, 7, 4, 0};
        IO.println(Arrays.toString(numArray));
        invert(numArray);
        IO.println(Arrays.toString(numArray));
    }

    public static void invert(int[] numArray) {
        // we use two counters, one starting from 0, the other from arraylength-1
        for (int i=0, j=numArray.length-1; i < j; i++, j--) {
            swap(numArray, i, j);
        }
    }

    public static void swap(int[] numArray, int i, int j) {
        // we swap the two integers with the 3rd temp variable technique we already seen
        int temp = numArray[i];
        numArray[i] = numArray[j];
        numArray[j] = temp;
    }
}
