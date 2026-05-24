package org.generation.italy.examples.homework;

public class Exercise7 {
    /*
    7) Scrivi una funzione che riceve in input un numero
     n e ritorna un vettore bidimensionale (matrice) n x n in cui
      tutti i valori sono zero tranne quelli sulla diagonale

     */

    static int[][] createMatrixWithDiagonals(int side){
        int[][] matrix = new int[side][side];

        for(int i = 0, diagonalCounter = 0, diagonalCounterMirror = side -1; i < side; i++,diagonalCounter++, diagonalCounterMirror--){
            for(int j = 0; j < side; j++){
                if(j == diagonalCounter || j == diagonalCounterMirror ){
                    matrix[i][j] = 1;
                }else{
                    matrix[i][j] = 0;
                }

            }
        }

        return matrix;
    }
}
