package org.generation.italy.examples.arrays;

public class ExerciseBinarySearch {
    static void main() {
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        int index = indexOf(numbers,3);
        System.out.println(index);
    }

    public static int indexOf(int[] numbers, int num){
        // inizio array
        int start = 0;
        // fine array
        int end = numbers.length -1;
        // indice del numero da trovare

        // Il ciclo va avanti finchè start è minore di end
        while(start <= end){
            // found prende il valore dell'indice a metà dell'array
            // se troviamo subito la corrispondenza ritorniamo subito l'indice del numero richiesto
            int found = (start + end) / 2;
            if (num == numbers[found]){
                return found;
            }
            // se non troviamo subito la corrispondenza controlliamo se il numero in input se è uguale a quello trovato
            if (num < numbers[found]) {
                end = found - 1;
            } else {
                start = found + 1;
            }
        }
        return -1;
    }
}
