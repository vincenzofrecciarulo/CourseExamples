package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise3 {
    // Creiamo una funzione che riceve in input un array e lo inverte
    // Senza creare altri array

    static void main() {
        int[] numArray = {1,4,5,2,6,3,8,3,4,8};
        IO.println(Arrays.toString(numArray));
        invert(numArray);
        IO.println(Arrays.toString(numArray));
    }

    public static void invert(int[] numArray) {
        for (int i=0, j =numArray.length-1; i < j; i++, j--) {
            swap(numArray, i, j);
        }
    }

    public static void swap(int[] numArray, int i, int j) {
        int temp = numArray[i];
        numArray[i]=numArray[j];
        numArray[j]= temp;
    }


}
