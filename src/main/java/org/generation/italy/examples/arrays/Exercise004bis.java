package org.generation.italy.examples.arrays;

import java.util.Arrays;

//segui es 4 elimina mx e min dalla media
public class Exercise004bis {
    public static void main(String[] args){
        double[] numbers = new double[10];
        randomNumbers(numbers);
        double max = findMax(numbers);
        double min = findMin(numbers);
        double sum=0;
        for(int i=0;i<numbers.length;i++){
            sum+=numbers[i];
        }
        double avr=(sum-max-min)/(numbers.length-2);
        IO.println(Arrays.toString(numbers));
        IO.println(max +" "+ min);
        IO.println(avr);

    }

    private static double findMin(double[] numbers) {
        double min=numbers[0];
        for (int i=0;i<numbers.length;i++){
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        return min;
    }

    private static double findMax(double[] numbers) {
        double max=numbers[0];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>max){
                max=numbers[i];
            }
        }
        return max;
    }

    static void randomNumbers(double[] numbers) {
        for(int i=0;i<numbers.length;i++){
            numbers[i]= Math.random()*100;
        }
    }
}
