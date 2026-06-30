package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*crea un array di 10 elementi casuali e stampa solo quelli
che sono duplicati*/
public class Exercise002tris {
    public static void main(String[] args){
        int[] numbers = new int[10];
        ramdomNumbers(numbers);
        IO.println(Arrays.toString(numbers));
        hasUniqueDuplicate(numbers);
    }

    private static void hasUniqueDuplicate(int[] numbers) {
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                continue;
            }
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]==numbers[j]) {
                    numbers[j]=0;
                   IO.println(numbers[i]);
                }
            }
        }
    }

    private static void ramdomNumbers(int[] numbers) {
        for (int i=0;i<numbers.length;i++){
            numbers[i]=(int)(Math.random()*10)+1;
        }
    }
}
