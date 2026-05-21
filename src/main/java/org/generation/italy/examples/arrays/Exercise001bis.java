package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise001bis {
    public static void main(){
        int[]  numbers= new int[10];
        populateNumbers(numbers);
        int[] temp=new int[10];
        temp = invertNumbers(numbers,temp);
        IO.println(Arrays.toString(numbers));
        IO.println(Arrays.toString(temp));
    }

    private static int[] invertNumbers(int[] numbers,int[] temp) {
        for(int i=0;i<numbers.length;i++){
            temp[numbers.length-1-i]=numbers[i];

        }
        return temp;
    }

    private static void populateNumbers(int[] numbers) {
        for(int i=0;i<numbers.length;i++){
            numbers[i]=(int)(Math.random()*10)+1;
        }
    }
}
