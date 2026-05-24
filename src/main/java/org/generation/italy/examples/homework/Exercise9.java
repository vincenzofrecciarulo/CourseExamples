package org.generation.italy.examples.homework;

public class Exercise9 {
    /*
    9) Scrivi una funzione che riceve in input due matrici bidimensionali
     e ritorna la matrice che e' loro prodotto. (sai come si calcola il prodotto tra matrici?)
     */

    static int[][] matrixProduct(int[][] firstMatrix, int[][] secondMatrix) throws Exception {
        int firstMatrixColumnCount = firstMatrix[0].length;
        int firstMatrixRowCount = firstMatrix.length;
        int secondMatrixColumnCount = secondMatrix[0].length;
        int secondMatrixRowCount = secondMatrix.length;


        if(firstMatrixColumnCount != secondMatrixRowCount){
            throw new Exception("Il numero di colonne della prima matrice deve essere uguale al numero di righe della seconda");
        }

        int[][] result = new int[firstMatrixRowCount][secondMatrixColumnCount];

        for(int i = 0; i < firstMatrixRowCount; i++){
            for(int j = 0; j < secondMatrixColumnCount; j++){
                int[] secondMatrixColumn = new int[secondMatrixRowCount];
                for(int k = 0; k < secondMatrixRowCount; k++){
                    secondMatrixColumn[k] = secondMatrix[k][j];
                }
                result[i][j] = calculateCellValue(firstMatrix[i], secondMatrixColumn);
            }
        }

        return  result;
    }

    static int calculateCellValue(int[] row, int[] column){
        int result = 0;
        for(int i = 0; i < row.length; i++){
            result += (row[i] * column[i]);
        }
        return result;
    }
}
