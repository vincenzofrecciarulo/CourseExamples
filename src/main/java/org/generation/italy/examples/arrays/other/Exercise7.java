/*
Ex3
Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore (1) - (100),
invocarla sull’array e stampare il valore massimo e il valore minimo

Ex3Bis (solitaria)
Rifarlo ma con valori (-100) - (+100)
 */

package org.generation.italy.examples.arrays.other;

import java.util.Arrays;

public class Exercise7 {
    static void main() {
        int[] array = new int[10];
        popolaArray(array, -100, 100);
        System.out.println(Arrays.toString(array));
        stampaMinimoMassimo(array);
    }

    static int generaNumeriCasuali(int a, int b){
        if (a >= b) {
            throw new IllegalArgumentException("Il parametro a deve essere inferiore al parametro b"); //lancia eccezione che interrompe programma con messagio di errore
        }
        double number = Math.random();
        return (int) Math.floor(number*(b-a+1))+a; //math.floor arrotonda per diffetto.
    }
    static void popolaArray(int[] array,int a, int b){
        for(int i = 0; i < array.length; i++){
            array[i] = generaNumeriCasuali(a, b);
        }
    }
    static void stampaMinimoMassimo(int[]array){
        assert array.length > 0;               //l'array dev'essere maggiore di 0, oppure errore.
        int min = array[0];
        int max = array[0];
        for(int i = 0; i< array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
            if (array[i] > max){
                max = array[i];
            }
        }
        System.out.println("Il numero massimo è: "+max+"\nMentre il minimo è: "+min);
    }
}
