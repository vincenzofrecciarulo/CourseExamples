package org.generation.italy.examples.arrays.casa;

//Ex.3:
//Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore (1) - (100), invocarla sull’array e stampare il valore massimo e il valore minimo

//Ex.3Bis:
//Rifarlo ma con valori (-100) - (+100)

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args){
        int[] array= new int[10];

        populateArray(array);

        IO.println(Arrays.toString(array));
    }

    public static void populateArray(int[] array) {
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*100)+1;
        }
    }

    public static void findMax(int[] array){
        for(int i=0; i<array.length;i++){
            int max = array[i];
            if(max>array[i])
        }

    }
}
