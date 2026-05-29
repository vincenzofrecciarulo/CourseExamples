package org.generation.italy.examples.riccardoExercises;

/*
Realizza un gioco di tris in cui a turno il giocatore e il computer pongono
il loro segno fino a vincere o pareggiare.
*/

import java.util.Arrays;

public class Exercise10 {

    static void main() {
        String[][] board = new String[3][3];
        board = prepareBoard(board);
        printBoard(board);

    }


    public static String[][] prepareBoard(String[][] board){

        for (int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++)
            board[i][j] = "";
        }
        return board;
    }

    public static void printBoard(String[][] board ){
        for (int i = 0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
    public static void gameCircle (String[][] board){
        int fullCells = 0;
         boolean victory = false;
        while (!victory && fullCells ==9){

        }

    }


}
