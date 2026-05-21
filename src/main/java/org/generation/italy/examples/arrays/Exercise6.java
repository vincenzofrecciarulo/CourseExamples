package org.generation.italy.examples.arrays;

public class Exercise6 {
    /*
    scrivere una funzione che riceva un array di interi e
    ritorni la moda, ossia il valore che appare più volte nell'array.
    se ci sono più mode, la funzione deve ritornarne una casuale.
    questo metodo funziona, se ci sono più mode ritorna la prima.
    non gestisce array vuoti.
    */
    public static int findMode(int[] numbers) {
        int modeCounter = 0;
        int mode = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            int tempCounter = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    tempCounter++;
                }
            }
            if (tempCounter > modeCounter) {
                modeCounter = tempCounter;
                mode = numbers[i];
            }
        }
        return mode;
    }
}
