package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Ex1Bis (solitaria)
Dato un array di 10 elementi di qualunque tipo,
scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso
 */
public class Exercise1Bis {
    static void main() {
        int[] numbers = {1,2,3,4,5,6,7,8};
        IO.println(Arrays.toString(numbers));
        printReverseArray(numbers);
    }

    public static void printReverseArray(int[] arr){
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            temp[arr.length-1-i] = arr[i];
        }
        IO.println(Arrays.toString(temp));
    }
}
