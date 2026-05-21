package org.generation.italy.examples.arrays;

public class Exercise4 {
    // Creare una funzione che riceve in input
    // un array di interi e ritorna il massimo numero intero che trova nell'array
    public static int findMax(int[] numbers){
        int max = numbers[0];

        for(int i = 1; i < numbers.length - 1; i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }

        return max;
    }


    // Creare una funzione che riceva in input un array di numeri e ne restituisca il suo valore medio

    public static double findAverage(int[] numbers){
        double sum = 0;

        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        double average = sum/numbers.length;
        return average;
    }

    // Creare una funzione che riceva in input un array di interi e mi restituisca true se l'array
    // non contiene duplicati, false se contiene almeno un numero duplicato

    public static boolean hasUniqueNumbers(int[] numbers){
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] == numbers[j]){
                    return false;
                }
            }
        }
        return true;
    }

}
