package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise3 {
    // una funzione che riceve come input un array e lo inverte senza usare un array di appoggio

    static void main(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        IO.println(Arrays.toString(numbers));

        invert(numbers);

        IO.println(Arrays.toString(numbers));
    }

    static void invert(int[] array) {
        for(int i = 0, j = array.length -1; i < j; i++, j--){
            swap(array, i, j);
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
