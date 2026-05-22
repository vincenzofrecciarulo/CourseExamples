package org.generation.italy.examples.arrays;
/*
Ex2Tris (solitaria) - DIFFICILE, consiglio di farlo per ultimo
Dato un array di 10 elementi,
scrivere una funzione che popola l’array con numeri interi casuali di valore 1-10.
Successivamente il programma deve stampare gli elementi duplicati

 */
public class Exercise2Tris {
    static void main() {
        int[] numbers = {1,1,4,4,1,3,3,4,9};
        hasUniqueNumbers(numbers);
    }
    public static void populateRandomNumbersArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10)+ 1;
        }

    }
    public static void hasUniqueNumbers(int[] arr){
        // primo ciclo per camminare lungo tutto l'array
        for (int i = 0; i < arr.length; i++){
            // variabile per controllare se il numero è gi astato controllato
            boolean hasChecked = false;
            // secondo ciclo per camminare di nuovo sull'array
            // lo faccio sempre partire da 0 ma continua finche j < i
            for (int j = 0; j< i; j++){
                // se la prima iterazione è uguale alla seconda
                // gli diciamo che l'abbiamo controllato e facciamo un break ed usciamo dal secondo ciclo
                if (arr[i] == arr[j]){
                    hasChecked = true;
                    break;
                }
            }
            // una volta usciti dal secondo ciclo controlliamo se la variabile booleana se questa e true non entro in questo if
            // altrimenti entro e controllo con un altro ciclo se piu avanti ritrovo quel numero
                if (!hasChecked){
                    for (int k = i + 1; k < arr.length; k++){
                        if (arr[i] == arr[k]){
                        IO.println(arr[i]);
                        break;
                        }
                    }
                }
        }

    }
}
