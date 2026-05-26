package org.generation.italy.examples.Exercises;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ExerciseArray7 {
/*
Data una matrice quadrata N×N, stampa gli elementi della diagonale principale e
della diagonale secondaria, e calcola le loro somme
 */
    static void main() {
        //dichiaro la matrice quadrata
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        //dichiaro il vettore diagonale principale
        int[] mainDiagonal = new int[matrix.length];
        //dichiaro il vettore diagonale secondaria
        int[] secondDiagonal = new int[matrix.length];

        int sumMainDiagonal = 0;
        int sumSecondDiagonal = 0;

        //creo un ciclo for per scorrere la matrice ed un if al suo interno per salvare i valori della diagonale nel suo vettore
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(i == j){
                    mainDiagonal[i] = matrix[i][j];
                }
            }
        }
        IO.println("La diagonale principale è:");
        IO.println(Arrays.toString(mainDiagonal));

        for(int i = 0; i < mainDiagonal.length; i++){
            sumMainDiagonal+= mainDiagonal[i];
        }
        IO.println("La somma della diagonale principale é:");
        IO.println(sumMainDiagonal);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(i + j == 2){
                    secondDiagonal[i] = matrix[i][j];
                }
            }
        }
        IO.println("la diagonale secondaria è:");
        IO.println(Arrays.toString(secondDiagonal));

        for(int i = 0; i < secondDiagonal.length; i++){
            sumSecondDiagonal+= secondDiagonal[i];
        }
        IO.println("La somma della diagonale secondaria é:");
        IO.println(sumSecondDiagonal);
    }
}
