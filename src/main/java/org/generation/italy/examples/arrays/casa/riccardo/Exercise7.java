package org.generation.italy.examples.arrays.casa.riccardo;

import java.util.Random;

// Scrivi una funzione che riceve in input un numero n
// e ritorna un vettore bidimensionale (matrice) n x n
// in cui tutti i valori sono zero tranne quelli sulla diagonale

public class Exercise7 {
    public static void main(String[] args){
        int number;

        do{
            String numberStr = IO.readln("Inserisci un numero intero maggiore o uguale a 1 per definire la dimensione della matrice: ");
            number = Integer.parseInt(numberStr);

            if(number < 1) {
                System.out.println("Il numero inserito non è valido!");
                System.out.println("Reinserisci il numero!");
                System.out.println();
            }
        }while(number < 1);

        int[][] bidMatrix = returnMatrix(number);
        System.out.println("La matrice è: ");
        System.out.println();
        printMatrix(bidMatrix);
    }

    public static int[][] returnMatrix (int num){

        Random randomNum = new Random();

        int[][] matrix = new int[num][num];

        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if (i==j){
                    matrix[i][j] = randomNum.nextInt(10) + 1; // con quel "+1" ci escono i numeri da 1  10, così differenziamo la diagonale da tutti gli altri zeri nella matrice
                }else{
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
