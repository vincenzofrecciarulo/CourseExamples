package org.generation.italy.examplesMio.arraysMio;

//Dato un array di 11 String di cui 10 vuote e 1 di valore “U” (inizialmente all’indice 5), simulare il problema del cammino dell’ubriaco:
//A ogni passo l’ubriaco “U” si sposta casualmente verso sinistra o verso destra di 1 posizione nell’array. L’ubriaco continua a spostarsi finché non esce dall’array.
//
//Ad ogni passo, stampare la visualizzazione grafica di tutto l’array per mostrare la posizione attuale dell’ubriaco.
//
//Il programma non deve crashare quando l’ubriaco sta per uscire dall’array.
//
//Alla fine dell’esecuzione, stampare il numero di passi che l’ubriaco ha compiuto prima di uscire.
//
//
//int randomInt = (int)(Math.random() * (max - min + 1)) + min;**


import java.util.Arrays;

public class Excercise6 {
    static void main() {
        String[] drunkArr = new String[11];
        drunkArr[5] = "U";

        int maxVal = +1;
        int minVal = -1;

        int drunkPosition = 5;

        int count = 0;


        while(drunkPosition >= 0 && drunkPosition <= 10){
            int randomInt = (int)(Math.random() * (maxVal - minVal + 1)) + minVal;
            drunkArr[drunkPosition] = null; // svuota la vecchia posizione
            drunkPosition = drunkPosition + randomInt;

            if(drunkPosition >= 0 && drunkPosition <= 10){
                drunkArr[drunkPosition] = "U";
            }

            count++;
            IO.println(Arrays.toString(drunkArr));
        }
        IO.println("Passi: " + count);
    }
}
