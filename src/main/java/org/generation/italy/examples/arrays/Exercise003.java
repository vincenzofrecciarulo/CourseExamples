package org.generation.italy.examples.arrays;

import java.util.Arrays;

import static org.generation.italy.examples.arrays.Exercise002.populateArray;

/*dato un array di 10 elementi, scrivere una funzione
che popola l'array con numeri interi casuali
di valore 1 - 100, invocarla e stampare il massimo e il minimo
 */
public class Exercise003 {
    public static void main(){
        int[] numbers = new int[10];
        populateNumbers(numbers);
        int max = numbers[0];
        int min = numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>max){
                max=numbers[i];
            }
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        IO.println(Arrays.toString(numbers));
        IO.println(max);
        IO.println(min);
    }

    public static void populateNumbers(int[] numbers) {
        for(int i=0;i<numbers.length;i++){
            numbers[i]=(int) (Math.random()*100)+1;
        }
    }
}
