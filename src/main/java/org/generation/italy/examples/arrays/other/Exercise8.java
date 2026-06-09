/*
Ex4
Dato un array di 10 elementi, scrivere una funzione che popola l’array con double casuali di valore (0) - (100),
invocarla sull’array e stamparne la media matematica

Ex4Bis (solitaria)
Rifarlo ma calcolando la media senza il valore massimo e il valore minimo

Ex4Tris (solitaria)
Popolare l’array e stamparne solo gli elementi che distano più di 10 dalla media di tutto l’array
*/

package org.generation.italy.examples.arrays.other;

import java.util.Arrays;

public class Exercise8 {
    static void main(String[] args) {
        double[] array = new double[10];
        popolaArray(array, 0, 100);
        System.out.println(Arrays.toString(array));
        System.out.println("Il valore medio dell'array è: "+calcolaMedia(array));
        System.out.println("I numeri distanti più di 10 dalla media sono: ");
        stampaValoriDistanti(array, 10);
    }

    static double generaNumeriCasuali(double a, double b){
        if (a >= b) {
            throw new IllegalArgumentException("Il parametro a deve essere inferiore al parametro b"); //lancia eccezione che interrompe programma con messagio di errore
        }
        double number = Math.random()*(b-a)+a;
        return number;
    }
    static void popolaArray(double[] array,double a, double b){
        for(int i = 0; i < array.length; i++){
            array[i] = generaNumeriCasuali(a, b);
        }
    }
    static double calcolaMedia(double[]array){
        assert array.length > 0;  //l'array dev'essere maggiore di 0, oppure errore.
        double sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        double media = sum / (double)array.length;
        return media;
    }
    static void stampaValoriDistanti(double[]array, double distanza){
        assert array.length > 0;
        assert distanza >= 0;
        double media = calcolaMedia(array);
        for (int i = 0; i < array.length; i++){
            if (Math.abs(array[i] - media) > distanza){
                System.out.println(array[i]);
            }
        }
    }
}
