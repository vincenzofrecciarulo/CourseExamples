package org.generation.italy.examples.arrays.casa;

import java.util.Arrays;

public class Ex3 {

    //Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali
    // di valore (1) - (100), invocarla sull’array e stampare il valore massimo e il valore minimo
    //Ex3Bis : Rifarlo ma con valori (-100) - (+100)

    static void main() {
        int[] array = new int[10];
        int max=0;
        int min=0;


        populateArray(array);
        IO.println(Arrays.toString(array));

        max=findMax(array);
        min=findMin(array);

        System.out.println(max);
        System.out.println(min);


    }

    public static void populateArray(int[] arrayDelMetodo) { //l'array del metodo non c'entra nulla con l'array della main
        for (int i = 0; i < arrayDelMetodo.length; i++) {
            arrayDelMetodo[i] = (int) (Math.random() * 100) + 1; //Math random da un valore da 0.0 a 0.99, quindi lo
            //moltipichiamo per il valore massimo che vogliamo ottenere e aggiungiamo 1 per correggere il taglio dei decimali.


        }

    }

        public static int findMax ( int[] numbers)
        {
            int max = numbers[0];
            for (int i = 1; i < numbers.length; i=i+1) { //il for con un array serve sempre a far girare tutte le posizioni dell'array
                if (numbers[i] > max) {
                    max = numbers[i];
                }

            }

                 return max;


        }
           public static int findMin (int[] minimum){

           int min= minimum[0];
           for(int i = 1; i < minimum.length; i++){
               if (minimum[i] < min) {
                   min= minimum[i];
               }
           }

                return min;
        }

    }



