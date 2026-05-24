package org.generation.italy.examples.homework;

public class Exercise8 {
    /*
    8) Scrivi una funzione che riceve in input due matrici bideminsionali e ritorna la matrice che rappresenta la somma delle matrici

     */

    static int[][] sumMatrixes(int[][] firstMatrix, int[][] secondMatrix){
        int firstMatrixHeight = firstMatrix.length;
        int secondMatrixHeight = secondMatrix.length;
        int firstMatrixBase = firstMatrix[0].length;
        int secondMatrixBase = secondMatrix[0].length;
        int height = firstMatrixHeight > secondMatrixHeight ? firstMatrixHeight : secondMatrixHeight;
        int base = firstMatrixBase > secondMatrixBase ? firstMatrixBase : secondMatrixBase;

        int[][] matrixSum = new int[height][base];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < base; j++){
                int firstMatrixCellValue = 0;
                int secondMatrixCellValue = 0;
                if(i < firstMatrixHeight && j < firstMatrixBase){
                    firstMatrixCellValue = firstMatrix[i][j];
                }
                if(i < secondMatrixHeight && j < secondMatrixBase){
                    secondMatrixCellValue = secondMatrix[i][j];
                }
                matrixSum[i][j] = firstMatrixCellValue + secondMatrixCellValue;

            }
        }

        return  matrixSum;

    }
}
