package org.generation.italy.examples.arrays;

/*

Dato un array di 10 elementi, scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
 Successivamente il programma deve stampare gli elementi duplicati

 */

import java.util.Arrays;

public class Exercise11 {
 public   static void main(String[] args) {
        int[] numbers = new int[10];
        populateArray(numbers);
        System.out.println(Arrays.toString(numbers));
         printDuplicates(numbers);
    }

    public static void populateArray(int[] numbers){
        for (int i = 0; i< numbers.length;i++){
            numbers[i] = (int) ((Math.random()*10)+1);
        }
    }

    public static void printDuplicates (int[] numbers){
        boolean alreadyPrinted = false;
        boolean duplicateFound = false;

        for (int i =0;i<numbers.length-1;i++){
            alreadyPrinted = false;//reset boolean
            duplicateFound = false;//reset boolean
            for(int j= i+1;j<numbers.length;j++){
                if(numbers[i] == numbers[j]){
                    duplicateFound = true;
                    break;
                }
                  for (int k =i-1; k>=0;k--){
                     if(numbers[i]==numbers[k]){
                        alreadyPrinted = true;
                        break;
                      }
                }

            }

            if(alreadyPrinted == false && duplicateFound ==true ){
                System.out.print(numbers[i]+" ");
            }


        }

    }



}
