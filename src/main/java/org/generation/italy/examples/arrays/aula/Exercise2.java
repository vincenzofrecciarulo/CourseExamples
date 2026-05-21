package org.generation.italy.examples.arrays.aula;

import java.util.Arrays;

// scrivere funzione che popola array con numeri interi casuali da 1 a 10

public class Exercise2 {
    static void main(){
        int[]  array= new int[10];

        populateArray(array);
        IO.println(Arrays.toString(array));
    }

    static void populateArray(int[] array) {
            for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*10)+1;
        }

    }

}
