package org.generation.italy.examples.arrays;

import java.util.Arrays;

/* dato un array di 10 elementi scrivere una funzione che popola
un array con numeri interi casuali dal valore 1-10
il programma deve stampare se ci sono elementi duplicati o no
 */
public class Exercise002bis {
    public static void main(String[] args){
        int[] numbers = new int[10];
        randomNumbers(numbers);
        IO.println(Arrays.toString(numbers));
        hasUniqueNumbers(numbers);
        if(hasUniqueNumbers(numbers)){
            IO.println("no, non ci sono dei duplicati");
        }else{
            IO.println("si, ci sono dei duplicati");
        }
    }

    static void randomNumbers(int[] numbers) {
        for(int i=0;i<numbers.length;i++){
            numbers[i]=(int)(Math.random()*10)+1;
        }
    }
    static boolean hasUniqueNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]==numbers[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
