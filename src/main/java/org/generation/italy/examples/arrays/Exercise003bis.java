package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*dato un array di 10 elementi, scrivere una funzione
che popola l'array con numeri interi casuali
di valore -100 a 100, invocarla e stampare il massimo e il minimo
 */
public class Exercise003bis {
    public static void main(String[] args){
        int[] numbers = new int[10];
        randomNumbers(numbers);
        int max=numbers[0];
        int min=numbers[0];
        max = findMax(numbers,max);
        min = findMin(numbers,min);
        IO.println(Arrays.toString(numbers));
        IO.println(max);
        IO.println(min);
    }

    private static int findMin(int[] numbers, int min) {
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        return min;
    }

    static int findMax(int[] numbers, int max) {
        for(int i=0;i<numbers.length;i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    private static void randomNumbers(int[] numbers) {
        for(int i=0;i<numbers.length;i++){
            numbers[i]=(int)(Math.random()*201)-100;
        }
    }
}
