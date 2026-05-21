package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*scrivere una funzione che popola un array con
numeri interi casuali dal valore 1-10
 */
public class Exercise002 {
    public static void main(){
        int[] numbers = new int[10];
        populateArray(numbers);
    }
    static void populateArray(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            numbers[i]=(int) (Math.random()*10)+1;
        }
        IO.println(Arrays.toString(numbers));
    }
}
