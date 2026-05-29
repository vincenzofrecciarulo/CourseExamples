package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Dato un array di 10 elementi, scrivere una funzione che popola l’array con double casuali di valore (0) - (100),
 invocarla sull’array e stamparne la media matematica

*/
public class Exercise8 {
    static void main() {
        double[] numbers = new double[10];

        populateArrayDouble(numbers);
        System.out.println(Arrays.toString(numbers));

        double media =  calculateArrayMean(numbers);
        System.out.println("Media= "+media);
         /*
        parte bis
        Rifarlo ma calcolando la media senza il valore massimo e il valore minimo
     */

        double[] numbersNew = new double[10];

        populateArrayDouble(numbersNew);
        System.out.println(Arrays.toString(numbersNew));

         calculateMeanWithoutMaxOrMin(numbersNew);
         double mediaNew = calculateMeanWithoutMaxOrMin(numbersNew);
         System.out.println(mediaNew);

    }

    public static void populateArrayDouble(double[] numbers){
        for (int i = 0; i< numbers.length;i++){
            numbers[i] = (Math.random() * 100);
        }
    }
    public static double calculateArrayMean(double[] numbers){
        double sum = 0;
        double mean = 0;

        for (int i= 0; i<numbers.length;i++){
            sum+= numbers[i];
        }
        return mean = sum/numbers.length;


    }

    public static double calculateMeanWithoutMaxOrMin (double[] numbers){
        double max = calculateMax(numbers);
        double min = calculateMin(numbers);
        double sum = 0;
        double mean = 0;
        int maxMinCounter =0; //Conta il numero di elementi dell'array che hanno come valore max e min

          for (int i =0; i<numbers.length;i++){
              if(numbers[i] == max || numbers[i]==min){
                  maxMinCounter++;
                  continue;

              }
              else{
                  sum += numbers[i];
              }
          }
          return mean = sum/(numbers.length -maxMinCounter);
    }

    public static double calculateMax (double[] numbers){
        double max = numbers[0];
        for (int i =1;i<numbers.length;i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        return max;
    }



    public static double calculateMin (double[] numbers){
        double min = numbers[0];
        for (int i =1;i<numbers.length;i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }



}
