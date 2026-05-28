package org.generation.italy.examples.arrays;

/*
Creare una funzione che riceve in input un array di interi e ne ritorna la moda statistica (il numero che appare
più volte al suo interno). L'array non sarà mai vuoto e se ci sono diverse mode (dunque numeri che appaiono un uguale
numero di volte) ne riporta una casuale.
Se sono tutti numeri diversi ugualmente sono tutte mode e ne ritorna uno casuale.
VEDERE DI IMPLEMENTARE LA CASUALITà E NON SOLO LA PRIMA TROVATA.
 */
public class Exercise7 {

    static void main() {
        int[] numbers = new int [50];
        Exercise2.populateArray(numbers);

        int maxIndex = 0;
        int maxNumber = 1;
        for (int i=0; i<numbers.length; i++) {
            if (manyDuplicates(numbers, i) > maxNumber) {
                maxIndex = i;
                maxNumber = manyDuplicates(numbers, i);
            }
        }

        System.out.println("Moda dell'array: " + numbers[maxIndex] + "\nRipetizioni: " + maxNumber + "\n\n");
        for (int i : numbers) {
            System.out.print(i+",");
        }
    }

    public static int manyDuplicates(int[] array, int start) {
        int  counter= 1;
        for (int i = start+1; i < array.length; i++) {

            if (array[i]==array[start]) {
                counter++;
            }
        }
        return counter;
    }




}
