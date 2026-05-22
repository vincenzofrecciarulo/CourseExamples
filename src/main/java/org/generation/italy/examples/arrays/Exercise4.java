package org.generation.italy.examples.arrays;

import java.io.Console;

public class Exercise4 {

    void main(){
        int[] numbers = {2, 3, 8, 1, 99, 3, 2, 2};
        printDuplicates(numbers);
    }

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


    // Creare una funzione che riceva in input un array di interi e mi restituisca la moda
    public static int findModa(int[] numbers){
        int maxOccurence = 1;
        int moda = numbers[0];
        for(int i = 0; i < numbers.length - 1; i++){
            int currentOccurence = 0;

            for(int j = 0; j < numbers.length; j++){
                if(numbers[j] == numbers[i]){
                    currentOccurence += 1;
                }
            }

            if(currentOccurence > maxOccurence){
                maxOccurence = currentOccurence;
                moda = numbers[i];
            }
        }

        return moda;
    }

    //Dato un array di 10 elementi, scrivere una funzione che popola l’array
    // e successivamente il programma deve stampare gli elementi duplicati

    public static void printDuplicates(int[] numbers){
        String duplicateNumbers = "";

        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] == numbers[j]){
                    duplicateNumbers = duplicateNumbers + numbers[i] + " - ";
                    break;
                }
            }
        }
        System.out.println(duplicateNumbers);
    }

    //Dato un array di 10 elementi, scrivere una funzione che popola
    // l’array con numeri interi casuali di valore (1) - (100), invocarla
    // sull’array e stampare il valore massimo e il valore minimo
    public static void printMaxAndMin(int[] numbers){
        int max = numbers[0];
        int min = numbers[0];

        for(int i = 1; i < numbers.length - 1; i++){
            if(numbers[i] > max){
                max = numbers[i];
            }else if(numbers[i] < min){
                min = numbers[i];
            }
        }

        IO.println("Il massimo è: " + max);
        IO.println("Il minimo è: " + min);
    }

    /*
    Ex4
    Dato un array di 10 elementi, scrivere una funzione che popola l’array con double
     casuali di valore (0) - (100), invocarla sull’array e stamparne la media matematica
     */


}
