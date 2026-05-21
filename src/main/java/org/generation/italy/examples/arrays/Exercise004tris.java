package org.generation.italy.examples.arrays;

import java.util.Arrays;

public class Exercise004tris {
    public static void main(String[] args){
        double[] numbers = new double[10];
        double sum=0;
        double avr;
        randomNumbers(numbers);
        for(int i=0;i<numbers.length;i++){
            sum+=numbers[i];
        }
        IO.println(Arrays.toString(numbers));
        avr=sum/numbers.length;
        IO.println(avr);
        for(int j=0;j<numbers.length;j++){
            if(numbers[j]>avr+10 || numbers[j]<avr-10){
                IO.println(numbers[j]);
            }
        }

    }


    static void randomNumbers(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Math.random() * 100;
        }
    }
}
