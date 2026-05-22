package org.generation.italy.examples.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercise5 {
    /*

    Ex5 (solitaria)
    Dato un array di 11 String di cui 10 vuote e 1 di valore “U” (inizialmente all’indice 5), simulare il problema del cammino dell’ubriaco:
    A ogni passo l’ubriaco “U” si sposta casualmente verso sinistra o verso destra di 1 posizione nell’array. L’ubriaco continua a spostarsi finché non esce dall’array.
    Ad ogni passo, stampare la visualizzazione grafica di tutto l’array per mostrare la posizione attuale dell’ubriaco.
    Il programma non deve crashare quando l’ubriaco sta per uscire dall’array.
    Alla fine dell’esecuzione, stampare il numero di passi che l’ubriaco ha compiuto prima di uscire.

    int randomInt = (int)(Math.random() * (max - min + 1)) + min;
     */
    void main(){
        simulateDrunkMovement();
    }

    static void simulateDrunkMovement(){
        String[] array = {null, null, null, null, null, "U", null, null, null, null, null};
        int position = 5;
        int steps = 0;

        while(true){
            IO.println(Arrays.toString(array));
            int randomInt = (int) (Math.random() * (2));

            if(randomInt == 1){
                if(position + 1 > 10){
                    IO.println("Hai fatto " + steps + " passi.");
                    return;
                }
                array[position + 1] = array[position];
                array[position] = null;
                position++;
            }else{
                if(position - 1 < 0){
                    IO.println("Hai fatto " + steps + " passi.");
                    return;
                }
                array[position - 1] = array[position];
                array[position] = null;
                position--;
            }


            steps++;
        }
    }
}
