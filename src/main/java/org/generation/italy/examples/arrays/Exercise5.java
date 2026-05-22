package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Ex1
Dato un array di 10 elementi di qualunque tipo, invertire l’ordine degli elementi
Ex1Bis (solitaria)
Dato un array di 10 elementi di qualunque tipo,
scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso
Ex1Tris (solitaria)
Dato un array di 10 elementi di qualunque tipo,
scrivere una funzione che prenda un array di quel tipo e lo restituisca con gli elementi in ordine inverso
senza utilizzare un array temporaneo
(termine tecnico: in-place, cioè gli elementi rimangono sempre all’interno dell’array)

Ex2
Scrivere una funzione che popola un array con numeri interi casuali di valore 1-10.

Ex2Bis
Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
Successivamente il programma deve stampare un messaggio per l’utente dicendo se nell’array ci sono elementi duplicati o no.

Ex2Tris (solitaria) - DIFFICILE, consiglio di farlo per ultimo
Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
Successivamente il programma deve stampare gli elementi duplicati.

Ex3
Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore (1) - (100),
invocarla sull’array e stampare il valore massimo e il valore minimo.

Ex3Bis (solitaria)
Rifarlo ma con valori (-100) - (+100)

Ex4
Dato un array di 10 elementi, scrivere una funzione che popola l’array con double casuali di valore (0) - (100),
invocarla sull’array e stamparne la media matematica




 */
public class Exercise5 {
    static void main() {
        double[] test = new double[10];
        populateDouble(test);
        IO.println(Arrays.toString(test));
        double result = findAverageDouble(test);
        IO.println(result);

    }


    public static String populate(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()* (100 -(-100)+1))+(-100);
        }
            return  findMaxAndMin(arr);
    }

    public static void populateDouble(double[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (Math.random()* 100);
        }


    }
    public static double findAverageDouble(double[] arr){
        double sum = 0.0;
        for (int i = 0; i <arr.length; i++ ){
            sum += arr[i];
        }
        return  sum / arr.length;
    }

    public static String findMaxAndMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i ++){
            if(max <= arr[i]){
                max = arr[i];
            }else if(min > arr[i] ){
                min = arr[i];
            }
        }
        return "Valore massimo " + max + " Valore minimo " + min;
    }

    public static void invertOrder(int[] arr) {
        for (int i = 0, j = arr.length-1; i < j; i++, j--){
            swapOrder(arr,i,j);
        }
    }

    public static void swapOrder(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
