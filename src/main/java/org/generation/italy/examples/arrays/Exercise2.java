package org.generation.italy.examples.arrays;
import java.util.Arrays;
/*
Ex2
Scrivere una funzione che popola un array con numeri interi casuali di valore 1-10
 */
public class Exercise2 {
    static void main(){

        int[]  array= new int[10];

        populateArray(array);

        IO.println(Arrays.toString(array));
    }

    static void populateArray(int[] array) {
            for(int i=0;i<array.length;i++){
            // formula matematica per ricevere un numero random da 1 a 10
            array[i]=(int)(Math.random()*10)+1;
        }

    }

}
