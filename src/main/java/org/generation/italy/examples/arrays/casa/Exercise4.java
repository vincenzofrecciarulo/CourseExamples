package org.generation.italy.examples.arrays.casa;

// Ex.4:
//Dato un array di 10 elementi, scrivere una funzione che popola l’array con double casuali di valore (0) - (100), invocarla sull’array e stamparne la media matematica

// Ex.4Bis:
//Rifarlo ma calcolando la media senza il valore massimo e il valore minimo

// Ex.4Tris:
//Popolare l’array e stamparne solo gli elementi che distano più di 10 dalla media di tutto l’array

import java.util.Arrays;

public class Exercise4 {
    public static void main (String[] args){
        double[] firstArray= new double[10];
        populateFirstArray(firstArray);
        IO.println(Arrays.toString(firstArray));
        System.out.println("La prima media è: " + findFirstAverage(firstArray));
        System.out.print("\n");

        System.out.println("Il massimo è: " + findMax(firstArray));
        System.out.println("Il minimo è: " + findMin(firstArray));
        System.out.println("La seconda media è: " + findSecondAverage(firstArray));
        System.out.print("\n");

        System.out.print("I valori dell'array, che distano più di 10 dalla prima media, sono : ");
        findDistance(firstArray);
        System.out.print("\n");
    }

    public static void populateFirstArray(double[] array) {
        for(int i=0;i<array.length;i++){
            array[i]=(Math.random()*100);
        }
    }

    public static double findFirstAverage(double[] array){
        double firstSum = 0.0;
        double firstAvg = 0.0;
        for(int i=0; i<array.length; i++){
            firstSum = firstSum + array[i];
        }

        firstAvg = (double) firstSum/array.length;
        return firstAvg;
    }

    public static double findMax(double[] array){
        double max = array[0];
        for(int i=1; i<array.length;i++){
            if(array[i]>=max){
                max=array[i];
            }
        }

        return max;
    }

    public static double findMin(double[] array){
        double min = array[0];
        for(int i=1; i<array.length;i++){
            if(array[i]<=min){
                min=array[i];
            }
        }

        return min;
    }

    public static double findSecondAverage(double[] array){
        double secondSum = 0.0;
        double secondAvg = 0.0;
        for(int i=0; i<array.length; i++){
            secondSum = secondSum + array[i];
        }

        secondAvg = (double) (secondSum-findMax(array)-findMin(array))/(array.length-2);
        return secondAvg;
    }

    public static void findDistance(double[] array){
        final double distanceThreshold = 10;
        double average = findFirstAverage(array);

        for(int i=0; i<array.length; i++){
            double distance = Math.abs(array[i] - average);
            if(distance > distanceThreshold){
                System.out.print(array[i] + " ");
            }
        }
    }
}
