package org.generation.italy.examples.arrays;

/*
Dato un array di 11 String di cui 10 vuote e 1 di valore “U” (inizialmente all’indice 5),
 simulare il problema del cammino dell’ubriaco:
A ogni passo l’ubriaco “U” si sposta casualmente verso sinistra o verso destra di 1 posizione nell’array.
 L’ubriaco continua a spostarsi finché non esce dall’array.
Ad ogni passo, stampare la visualizzazione grafica di tutto l’array per mostrare la posizione attuale dell’ubriaco.
Il programma non deve crashare quando l’ubriaco sta per uscire dall’array.
Alla fine dell’esecuzione, stampare il numero di passi che l’ubriaco ha compiuto prima di uscire.


*/

import java.util.Arrays;

public class Exercise10 {

    static void main() {

        String[] ubriaco = new String[11];
        ubriaco[5] = "U";
         walkDrunk (ubriaco);


    }

    public static void walkDrunk (String[] ubriaco){
        int randomPos = 5 ;
        int passi = 0;
        System.out.println(Arrays.toString(ubriaco));// Posizione iniziale
        do{

            int movement = (int)(Math.random()*(1-(-1) +1))-1;
             if (movement == 0){
                continue;
             }
             randomPos+=movement;//Calcolo spostamento
             if (randomPos > ubriaco.length-1 || randomPos<0){
                 //Controllo se random pos esce dall'array
                 break;
             }
             ubriaco[randomPos] = ubriaco[randomPos - movement];
             ubriaco[randomPos - movement] = null;
            System.out.println(Arrays.toString(ubriaco));
             passi++;

        }while(randomPos >= 0 && randomPos < ubriaco.length);
        System.out.println(passi);

    }




}
