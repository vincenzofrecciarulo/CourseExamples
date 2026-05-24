package org.generation.italy.examples.homework;

import java.util.Arrays;
import java.util.Random;

public class Exercise10 {
    /*
    10) Realizza un gioco di tris in cui a turno il giocatore
     e il computer pongono il loro segno fino a vincere o pareggiare.
     */

    void main(){
        playTris();
    }

    static void playTris(){
        String[][] trisBoard = new String[3][3];
        String playerMark = "X";
        String computerMark = "O";


        IO.println("=============================");
        IO.println("Benvenuto al gioco di tris");
        IO.println("=============================");
        IO.println("");
        printBoard(trisBoard);
        Random random = new Random();
        do{
            IO.println("");
            IO.println("Inserisci le coordinate della cella che vuoi prendere (partendo da 0): ");
            int rowIndex = Integer.parseInt(IO.readln("Scegli la riga:  "));
            int columnIndex = Integer.parseInt(IO.readln("Scegli la colonna:  "));
            IO.println("===================================");

            if((rowIndex < 0 || rowIndex > 3) || (columnIndex < 0 || columnIndex > 3)){
                IO.println("Non hai inserito una cella valida");
                continue;
            }
            if(trisBoard[rowIndex][columnIndex] != null){
                IO.println(("La cella è stata già marchiata."));
                continue;
            }

            trisBoard[rowIndex][columnIndex] = playerMark;

            printBoard(trisBoard);

            if(checkWin(trisBoard, playerMark)){
                IO.println("Congratulazioni hai vinto!");
                return;
            }


            boolean isCellAssigned = false;
            IO.println("===================================");
            IO.println("Turno del CPU");
            IO.println("===================================");
            do{
                int cpuRowIndex = random.nextInt(3);
                int cpuColumnIndex = random.nextInt(3);
                if(trisBoard[cpuRowIndex][cpuColumnIndex] == null){
                    trisBoard[cpuRowIndex][cpuColumnIndex] = computerMark;
                    isCellAssigned = true;
                }
            }while(!isCellAssigned);

            printBoard(trisBoard);
            if(checkWin(trisBoard, computerMark)){
                IO.println("Il computer ha vinto!");
                return;
            }

        }while(true);
    }



    static void printBoard(String[][] trisMatrix){
        for (String[] matrix : trisMatrix) {
            IO.println(Arrays.toString(matrix));
        }
    }

    static boolean checkWin(String[][] trisBoard, String cell){
        //controllo orizzontalmente
        for(int i = 0; i < trisBoard.length; i++){
            int markCount = 0;
            for(int j = 0; j < trisBoard.length; j++){
                if(trisBoard[i][j] != null && trisBoard[i][j].equalsIgnoreCase(cell)){
                    markCount++;
                }
            }
            if(markCount == trisBoard.length){
                return true;
            }
        }

        //controllo verticalmente
        for(int i = 0; i < trisBoard.length; i++){
            int markCount = 0;
            for(int j = 0; j < trisBoard.length; j++){
                if( trisBoard[j][i] != null && trisBoard[j][i].equalsIgnoreCase(cell)){
                    markCount++;
                }
            }
            if(markCount == trisBoard.length){
                return true;
            }
        }

        if(trisBoard[1][1] == null || !trisBoard[1][1].equalsIgnoreCase(cell)){
            return false;
        }

        if ((trisBoard[0][0] == null || trisBoard[2][2] == null) || (trisBoard[0][2] == null || trisBoard[2][0] == null)){
            return  false;
        }

        return (trisBoard[0][0].equalsIgnoreCase(cell) && trisBoard[2][2].equalsIgnoreCase(cell))
                || (trisBoard[0][2].equalsIgnoreCase(cell) && trisBoard[2][0].equalsIgnoreCase(cell));
    }
}
