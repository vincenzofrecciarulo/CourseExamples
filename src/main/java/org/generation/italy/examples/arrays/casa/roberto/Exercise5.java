package org.generation.italy.examples.arrays.casa.roberto;

// Ex.5:
// Dato un array di 11 String di cui 10 vuote e 1 di valore “U” (inizialmente all’indice 5),
// simulare il problema del cammino dell’ubriaco:
// A ogni passo l’ubriaco “U” si sposta casualmente verso sinistra o verso destra di 1 posizione nell’array.
// L’ubriaco continua a spostarsi finché non esce dall’array.
// Ad ogni passo, stampare la visualizzazione grafica di tutto l’array per mostrare la posizione attuale dell’ubriaco.
// Il programma non deve crashare quando l’ubriaco sta per uscire dall’array.
// Alla fine dell’esecuzione, stampare il numero di passi che l’ubriaco ha compiuto prima di uscire.
// int randomInt = (int)(Math.random() * (max - min + 1)) + min;

public class Exercise5 {
    public static void main(String[] args) throws InterruptedException{
        String[] array = new String[11];

        // Riempiamo l'array con spazi vuoti
        for (int i = 0; i < array.length; i++) {
            array[i] = "_";
        }

        // qui definiamo la posizione iniziale dell'ubriaco
        int posizione = 5;
        array[posizione] = "U";

        int passi = 0;

        // Continua finché l'ubriaco rimane dentro l'array (la posizione dell'ubriaco cambierà da 0 a 10 e non sarà sempre 5)
        while (posizione >= 0 && posizione < array.length) {

            // Stampa l'array
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }

            System.out.println();

            // Pulisce la posizione attuale
            array[posizione] = "_";

            // la formula della consegna è: int randomInt = (int)(Math.random() * (max - min + 1)) + min;
            // però l'ubriaco o si muove di un passo o non si muove e quindi dobbiamo generare casualmente o 0 o 1
            // quindi:
            int max = 1, min = 0;
            int direzione = (int)(Math.random() * (max - min + 1)) + min;
            // N.B. avremmo potuto scrivere la formula anche così: int direzione = (int)(Math.random() * 2);
            //      avendo sostituito direttamente max con 1 e min con zero

            // 0 = sinistra, 1 = destra
            if (direzione == 0) {
                posizione--;
            } else {
                posizione++;
            }

            passi++;

            // Controllo per evitare crash
            if (posizione >= 0 && posizione < array.length) {
                array[posizione] = "U";
            }

            // Piccola pausa per vedere meglio il movimento
            Thread.sleep(300);
        }

        System.out.println("\n");
        System.out.println("L'ubriaco è uscito dall'array.");
        System.out.println("Numero di passi compiuti: " + passi);
    }
}