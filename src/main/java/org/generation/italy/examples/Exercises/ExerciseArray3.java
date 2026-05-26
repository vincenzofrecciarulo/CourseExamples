package org.generation.italy.examples.Exercises;

public class ExerciseArray3 {
    /*
    Data una matrice 3×4 con numeri interi casuali (tra 1 e 100), trova e stampa il valore massimo presente nella matrice.
     */
    static void main() {
        int[][] matrix = new int[3][4];
        int max = 0;

        //creo un ciclo for che inserisce all'interno della matrice valori casuali da 1-100
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[1].length; j++){
                matrix[i][j] = (int)(Math.random()*100)+1;
                IO.print(matrix[i][j] + "    ");
            }
            IO.println();
        }

        //creo un ciclo for che mi permetta di trovare il massimo tra i valori della matrice
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0;  j < matrix[1].length; j++){
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
        }
        IO.println("il massimo numero nella matrice è: " + max);
    }
}
