package org.generation.italy.examples.arrays.casa;

public class ExerciseArrayBasic {
    //creare una funzione che riceve un array di interi e ritorna il massimo.

    public static int maxNumber(int[]numbers){ //creo la funzione di tipo intero perchè mi ritornerà un intero e do come parametro l'array di numberi interi.
        int max=numbers[0];                      //creo la variabile int max e le do come valore cella 0.
        for(int i=0; i<numbers.length; i++) {    //dichiaro il counter e inizio dalla prima cella dell'array fin quando il mio ciclo for non controllerà tutta la lunghezza
                                                 //dell'array numbers e ad ogni giro incremento di 1.
            if (numbers[i] > max) {              //se il valore salvato in i sarà > maggiore di max significa che quello sarà il numero massimo.
                max = numbers[i];
            }

        }
               return max;                      // mi ritorna il numero massimo.

        }


        }



