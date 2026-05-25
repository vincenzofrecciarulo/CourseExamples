package org.generation.italy.examples.arrays.casa.riccardo;

import java.util.Random;

// Scrivi una funzione che riceve in input due matrici bidimensionali
// e ritorna la matrice che e' il loro prodotto. (sai come si calcola il prodotto tra matrici?)

public class Exercise9 {
    public static void main(String[] args){

        int sizeRows, sizeRowsEqualCols, sizeCols;

        do {
            String sizeRowsStr = IO.readln("Inserisci la dimensione (>=1) delle righe della prima matrice: ");
            sizeRows = Integer.parseInt(sizeRowsStr);

            if(sizeRows < 1){
                System.out.println("Valore non valido!");
                System.out.println("Devi inserire un valore vaido!");
                System.out.println();
            }
        } while(sizeRows < 1);

        // N.B. qui definiamo la dimensione delle righe della prima matrice così:
        // Random randomFirstNum = new Random();
        // int sizeRows = randomFirstNum.nextInt(10) + 1;


        do {
            String sizeRowsEqualColsStr = IO.readln("Inserisci la dimensione (>=1) delle colonne della prima matrice (che sarà uguale alla dimensione delle righe della seconda matrice): ");
            sizeRowsEqualCols = Integer.parseInt(sizeRowsEqualColsStr);

            if(sizeRowsEqualCols < 1){
                System.out.println("Valore non valido!");
                System.out.println("Devi inserire un valore valido!");
                System.out.println();
            }
        } while(sizeRowsEqualCols < 1);

        // N.B. qui definiamo che la dimensione delle colonne della prima matrice (che sarà uguale alla dimensione delle righe della seconda matrice) così:
        // Random randomSecondNum = new Random();
        // int sizeRowsEqualCols = randomSecondNum.nextInt(10) + 1;


        do {
            String sizeColsStr = IO.readln("Inserisci la dimensione (>=1) delle colonne della seconda matrice: ");
            sizeCols = Integer.parseInt(sizeColsStr);

            if(sizeCols < 1){
                System.out.println("Valore non valido!");
                System.out.println("Devi inserire un valore valido!");
                System.out.println();
            }
        } while(sizeCols < 1);

        // N.B. qui definiamo la dimensione delle colonne della seconda matrice
        // Random randomThirdNum = new Random();
        // int sizeCols = randomThirdNum.nextInt(10) + 1;


        // da qui definiamo i numeri randomici che saranno dentro le matrici
        Random randomNumInMat = new Random();

        int[][] firstMatrix = new int[sizeRows][sizeRowsEqualCols];
        int[][] secondMatrix = new int[sizeRowsEqualCols][sizeCols];

        // qui riempiamo la prima matrice di numeri randomici
        for(int i = 0; i < sizeRows; i++){
            for(int j = 0; j < sizeRowsEqualCols; j++){
                firstMatrix[i][j] = randomNumInMat.nextInt(10);
            }
        }

        // qui riempiamo la seconda matrice di numeri randomici
        for(int i = 0; i < sizeRowsEqualCols; i++){
            for(int j = 0; j < sizeCols; j++){
                secondMatrix[i][j] = randomNumInMat.nextInt(10);
            }
        }

        System.out.println();
        System.out.println("La prima matrice è: ");
        printMatrix(firstMatrix);
        System.out.println();

        System.out.println("La seconda matrice è: ");
        printMatrix(secondMatrix);
        System.out.println();

        int[][] bidMatrix = multiplyMatrices(firstMatrix, secondMatrix);

        System.out.println("La matrice finale è: ");
        printMatrix(bidMatrix);
    }

    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix){

        int row = firstMatrix.length;
        int col = secondMatrix[0].length;
        int rowEqualCol = firstMatrix[0].length;

        int[][] finalMAtrix = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int sum = 0;

                for(int k = 0; k < rowEqualCol; k++){
                    sum = sum + firstMatrix[i][k] * secondMatrix[k][j];
                }

                finalMAtrix[i][j] = sum;
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
