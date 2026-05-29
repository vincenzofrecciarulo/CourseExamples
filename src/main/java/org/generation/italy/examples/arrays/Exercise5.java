package org.generation.italy.examples.arrays;

/*
 Dato un array di 10 elementi,
 scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
 Successivamente il programma deve stampare un messaggio per l’utente dicendo se nell’array ci sono elementi
  duplicati o no
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercise5 {
    static void main() {
        int[] numbers = new int[10];

        populateArray(numbers);
        IO.println(Arrays.toString(numbers));
        boolean check = checkDuplicates(numbers);

         if (check){
             System.out.println("L'array contiene duplicati");
         }else{
             System.out.println("L'array non contiene duplicati");
         }



    }






    public static void populateArray(int[] numbers){
       for (int i = 0; i< numbers.length;i++){
           numbers[i] = (int) ((Math.random()*10)+1);
       }
   }

   public static boolean checkDuplicates(int[] numbers){
        for (int i = 0; i<numbers.length-1;i++){
            for (int j = i+1;j<numbers.length;j++){
                if(numbers[i] == numbers[j]){
                    return true;
                }
            }
        }
        return false;
   }






}
