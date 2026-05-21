package org.generation.italy.examples.arrays;

public class Exercise4 {
    // creare una funzione che riceve in input un array di interi, e ritorna
    // il massimo numero intero all'interno dell'array
    // facciamoci domande sugli edge cases: array vuoti, array pieni di null...
    // è buona pratica chiamare i metodi con dei verbi

    public static int findMax(int[] numbers) {
        // since our array will have at least 1 element, this way
        // we take the first element and make it the max,
        // and we loop starting from the 2nd
        int max = numbers[0];
        for(int i = 0; i<numbers.length; i++) {
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // creare una funzione che riceva un array di interi, e restituisca
    // il suo valore medio (somma / n) come double
    public static double findAverage(int[] numbers) {
        double sum = 0;
        for(int i=0; i<numbers.length; i++) {
            sum += numbers[i];
        }
        return sum/numbers.length;
    }


    // creare una funzione che riceve un array di interi
    // e restituisce true se l'array non contiene duplicati,
    // false se contiene almeno un numero duplicato
    // questo algoritmo ha efficienza O(n^2) (Big O notation), perché per n iterazioni "esterne"
    // (del primo for) abbiamo n*n iterazioni "interne" (del secondo for)
    public static boolean hasUniqueNumbers(int[] numbers) {
        // it doesn't make sense to check the last number cause it's already checked
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
