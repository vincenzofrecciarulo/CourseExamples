package org.generation.italy.examples.arrays;

import java.util.Arrays;

/*
Ex5 (solitaria)
Dato un array di 11 String di cui 10 vuote e 1 di valore “U” (inizialmente all’indice 5),
simulare il problema del cammino dell’ubriaco:
A ogni passo l’ubriaco “U” si sposta casualmente verso sinistra o verso destra di 1 posizione nell’array.
L’ubriaco continua a spostarsi finché non esce dall’array.
Ad ogni passo,
stampare la visualizzazione grafica di tutto l’array per mostrare la posizione attuale dell’ubriaco.
Il programma non deve crashare quando l’ubriaco sta per uscire dall’array.
Alla fine dell’esecuzione, stampare il numero di passi che l’ubriaco ha compiuto prima di uscire.
 */
public class Exercise5 {
    static void main() {
        drunkGame();

    }
    public static void drunkGame(){
        String[] drunkPath = {" ", " ", " ", " ", " ", "U", " ", " ", " ", " ", " "};
        int drunkPosition = 5;
        int counter = 0;
        while (drunkPosition >= 0 && drunkPosition <= 10){
            int randomPass = (int)(Math.random() * 2);
            if (randomPass == 0){
                if (drunkPosition == 0){
                    drunkPath[0] = " ";
                    IO.println(Arrays.toString(drunkPath));
                    IO.println("è uscito da sinistra");
                    break;
                }
                drunkPath[drunkPosition] = " ";
                drunkPath[drunkPosition -1] = "U";
                drunkPosition--;
                counter++;
                IO.println(Arrays.toString(drunkPath));
            }
            if (randomPass == 1){
                if (drunkPosition == 10){
                    drunkPath[10] = " ";
                    IO.println(Arrays.toString(drunkPath));
                    IO.println("è uscito da destra");
                    break;
                }
                drunkPath[drunkPosition] = " ";
                drunkPath[drunkPosition +1] = "U";
                drunkPosition++;
                counter++;
                IO.println(Arrays.toString(drunkPath));
            }
        }
        IO.println("Ci sono voluti " + counter + " passi");
    }
}
