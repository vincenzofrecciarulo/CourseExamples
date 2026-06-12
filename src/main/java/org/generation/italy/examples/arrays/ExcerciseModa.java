package org.generation.italy.examples.arrays;
/* esercizio 1:

 creare una funzione statica che riceva in input

un array di stringhe, e restituisca la moda

 di queste stringhe (l'elemento che appare più volte
 l'algoritmo deve avere efficienza O(n)

 se ci sono più mode, ne ritorna una a caso */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Metodi delle mappe, contains restituisce booleano


public class ExcerciseModa {
    static void main (String[] args) {
        Map<String, Integer> wordsMap = new HashMap<>();
        String[] words = new String[10];
         for(int i=0; i<words.length; i++) {
            words[i] = IO.readln();
         }
        //System.out.println("The mode is" + findMostCommonWord(words));
        for(int i =0; i<words.length;i++)
        {
            if(wordsMap.containsKey(words[i]))
            {
                wordsMap.put(words[i],wordsMap.get(words[i])+1);
            } else {
                wordsMap.put(words[i],1);
            }

        }
        Integer maxValues=0;
        String modeKey;
        for(Integer n : wordsMap.values()){
            if(maxValues<n){
                maxValues=n;
            }

        }
        System.out.println("The mode compare" + maxValues);





        /*


    String[] words = new String[10];
    for(int i=0; i<words.length; i++) {
        words[i]= IO.readln();
    }
    System.out.println("The mode is" + findMostCommonWord(words));



    }
   static String  findMostCommonWord(String strings[]) {

        int a = strings.length;
        int counter=-1;
        int maxCount=0;
        int index=0;
        for(int i = 0;i<a;i++)
         {
             for(int i2=0; i2<a;i2++){
              if(strings[i]==strings[i2])
                 {
                     counter++;
                 }
                 if(counter>maxCount) {
                     maxCount = counter;
                     index =i;
                 }
         } counter =-1;




         }

   return strings(index);

    */
    }
}
