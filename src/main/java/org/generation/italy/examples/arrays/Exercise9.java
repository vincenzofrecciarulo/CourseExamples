package org.generation.italy.examples.arrays;
/*
Popolare l’array e stamparne solo gli elementi che distano più di 10 dalla media di tutto l’array
*/
import java.util.Arrays;

public class Exercise9 {
  public  static void main(String[] args) {
        int[] numbers = new int[10];

        populateArray(numbers);
        IO.println(Arrays.toString(numbers));

        printElementsMeanPlusTen(numbers);


    }
    public static void populateArray(int[] numbers){
        for (int i = 0; i< numbers.length;i++){
            numbers[i] = (int) ((Math.random()*100)+1);
        }
    }

    public static double calculateArrayMean(int[] numbers){
        double sum = 0;
        double mean = 0;

        for (int i= 0; i<numbers.length;i++){
            sum+= numbers[i];
        }
        return mean = sum/numbers.length;


    }

    public static void printElementsMeanPlusTen(int[] numbers){
        double mean = calculateArrayMean(numbers);
            for(int i=0;i<numbers.length;i++){
                if(Math.abs(numbers[i] - mean) > 10 ){
                    System.out.println(numbers[i]);
                }
            }

    }

}
