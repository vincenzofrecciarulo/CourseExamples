package org.generation.italy.examples.arrays.casa;

//Ex.3:
//Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore (1) - (100), invocarla sull’array e stampare il valore massimo e il valore minimo

//Ex.3Bis:
//Rifarlo ma con valori (-100) - (+100)

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args){
        int[] firstArray= new int[10];
        populateFirstArray(firstArray);
        IO.println(Arrays.toString(firstArray));
        printFindMax(firstArray);
        printFindMin(firstArray);

        int[] secondArray= new int[10];
        populateSecondArray(secondArray);
        IO.println(Arrays.toString(secondArray));
        printFindMax(secondArray);
        printFindMin(secondArray);
    }

    public static void populateFirstArray(int[] array) {
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*100)+1;
        }
    }

    public static void populateSecondArray(int[] array) {
        for(int i=0;i<array.length;i++){
            array[i]=(int)(Math.random()*201)-100;
        }
    }

    public static void printFindMax(int[] array){
        int max = array[0];
        for(int i=1; i<array.length;i++){
            if(array[i]>=max){
                max=array[i];
            }
        }

        System.out.println("Il massimo è: " + max);
    }

    public static void printFindMin(int[] array){
        int min = array[0];
        for(int i=1; i<array.length;i++){
            if(array[i]<=min){
                min=array[i];
            }
        }

        System.out.println("Il minimo è: " + min);
    }
}
