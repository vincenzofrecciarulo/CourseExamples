package org.generation.italy.examples.arrays;

import java.util.Arrays;

import static java.util.Collections.swap;

/*
crea funzione che riceve in input un array e lo inverte
 ma senza creare altri array di appoggio (come in Exercise1),
 lo inverte lavorando direttamente su quell'array
 */
public class Exercise3 {
    static void main(){
        int[] numArray={1,4,5,2,6,3,8,3,4,8};
        IO.println(Arrays.toString(numArray));
        invert(numArray);
        IO.println(Arrays.toString(numArray));
    }

    //faccio un ciclo con due variabili che una parte
    //da sinistra e l'altra da destra

    private static void invert(int[] numArray) {
        for (int i=0, j=numArray.length-1 ; i<j ; i++,j--){
            invertNum(numArray,i,j);
        }
    }

    private static void invertNum(int[] numArray, int i, int j) {
        int temp = numArray[i];
        numArray[i]=numArray[j];
        numArray[j]=temp;
    }
}
