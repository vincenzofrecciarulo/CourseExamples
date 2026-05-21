package org.generation.italy.examples.arrays;

import java.util.Arrays;

// Dato un array di 10 elementi, scrivere una funzione che popola l’array con double casuali di valore (0) - (100), invocarla sull’array e stamparne la media matematica
// Rifarlo ma calcolando la media senza il valore massimo e il valore minimo
// Popolare l’array e stamparne solo gli elementi che distano più di 10 dalla media di tutto l’array

public class Excercise5 {
    static void main() {
        double[] numArr = new double[10];
        double sum = 0;
        double media;

        doublePopulateArray(numArr);

        double max = numArr[0];
        double min = numArr[0];

        for(int i = 0; i < numArr.length; i++){
            if(numArr[i] > max){
                max = numArr[i];
            } else if(numArr[i] < min){
                min = numArr[i];
            }
            sum = sum + numArr[i];
        }


        sum = sum - min - max;

        media = sum / (numArr.length - 2);

        for(int i = 0; i < numArr.length; i++){
            if(media - numArr[i] > 10 || numArr[i] - media > 10){
               IO.println(numArr[i]);
            }
        }


        IO.println(Arrays.toString(numArr));
        IO.println("max: " + max);
        IO.println("min: " + min);
        IO.println("media: " + media);
    }

    public static void doublePopulateArray(double[] numArr) {
        for(int i =0; i < numArr.length; i++){
            numArr[i] = (Math.random()*100);

        }

    }
}
