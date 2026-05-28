package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Dato un array di 11 string di cui 10 vuote e 1 di valore "U" (default a index 5), simulare il problema del cammino
dell'ubriaco: A ogni passo U si sposta casualmente verso sinistra o destra di 1 posizione, continua a spostarsi
finchè non esce dall'array.
A ogni passo stampare la visualizzazione grafica di tutto l'array per mostrarne la posizione attuale.
Il programma non deve crashare quando l'ubriaco esce dall'array, alla fine di tutto poi stampare il numero di passi
che ha compiuto prima di uscire.

int randomInt = (int)(Math.random()*(max-min+1))+min;
 */
public class Exercise6 {
    static void main() {
        String[] drunkPath = new String[11];
        Arrays.fill(drunkPath,"_");
        drunkPath[5]="⏏";
        int posDrunk = 5;
        int posDrunkpre;

        while (true) {
            printArray(drunkPath);

            int random = (int)(Math.random()*101);
            if (random >= 50) {
                posDrunkpre = posDrunk;
                posDrunk += 1;
            } else {
                posDrunkpre = posDrunk;
                posDrunk -= 1;
            }

            if (posDrunk < 0 || posDrunk >= drunkPath.length) {
                System.out.println("\nIl bro si è perso...... R.I.P.");
                System.exit(0);
            }
            swap(drunkPath, posDrunk, posDrunkpre);
        }
    }

    public static void swap (String[] string, int x, int y) {
        String temp = string[x];
        string[x] = string[y];
        string[y] = temp;
    }

    public static void printArray (String[] string) {
        for (int i = 0; i < string.length; i++) {
            System.out.print(string[i]);
        }
        System.out.println("");
    }

}
