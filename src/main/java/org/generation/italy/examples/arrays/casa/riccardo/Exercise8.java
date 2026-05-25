package org.generation.italy.examples.arrays.casa.riccardo;

import java.util.Random;

// Scrivi una funzione che riceve in input due matrici bideminsionali
// e ritorna la matrice che rappresenta la somma delle matrici

public class Exercise8 {
    public static void main(String[] args){
        // nella consegna non ci viene detto che le righe e le colonne hanno la stessa dimensione
        // però imponiamo il fatto che abbiano le righe con la stessa dimensione e le colonne con la stessa dimensione
        // perchè sennò non le possiamo sommare

        // qui definiamo la dimensione delle righe delle matrici
        Random randomFirstNum = new Random();
        int sizeRows = randomFirstNum.nextInt(10) + 1;

        // qui definiamo la dimensione delle colonne delle matrici
        Random randomSecondNum = new Random();
        int sizeCols = randomSecondNum.nextInt(10) + 1;

        // N.B. potevamo definire le righe e le colonne direttamente da tastiera

        // da qui definiamo i numeri randomici che saranno dentro le matrici
        Random randomNumInMat = new Random();

        int[][] firstMatrix = new int[sizeRows][sizeCols];
        int[][] secondMatrix = new int[sizeRows][sizeCols];

        // qui riempiamo le matrici di numeri randomici
        for(int i = 0; i < sizeRows; i++){
            for(int j = 0; j < sizeCols; j++){
                firstMatrix[i][j] = randomNumInMat.nextInt(10);  // imponiamo che i numeri dentro le matrici vadano da 0 a 9
                secondMatrix[i][j] = randomNumInMat.nextInt(10); // e imponiamo lo stesso anche qui
            }
        }

        System.out.println("La prima matrice è: ");
        printMatrix(firstMatrix);
        System.out.println();

        System.out.println("La seconda matrice è: ");
        printMatrix(secondMatrix);
        System.out.println();

        int[][] bidMatrix = sumMatrices(firstMatrix, secondMatrix);

        System.out.println("La matrice finale è: ");
        printMatrix(bidMatrix);
    }

    public static int[][] sumMatrices(int[][] firstMatrix, int[][] secondMatrix){

        int rows = firstMatrix.length;     // "firstMatrix.length" restituisce il numero di righe della prima matrice
        int cols = firstMatrix[0].length;  // "firstMatrix[0].length" prende la riga con indice 0 (cioè la prima riga) e poi tramite "length" calcola quanti elementi contiene quella riga (e quindi quante colonne ci sono)

        int[][] finalMAtrix = new int[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                finalMAtrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        return finalMAtrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]); // abbiamo utilizzato printf e %4d per allineare i numeri e così sono anche ben distanziati
            }
            System.out.println();
        }
    }
}