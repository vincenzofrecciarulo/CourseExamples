package org.generation.italy.examples.homework;

import java.util.Arrays;
import java.util.Random;

public class Exercise11 {
    /*
    11) Crea una semplice implementazione di gioco di battaglia navale in cui il giocatore gioca contro il computer.
     */

    void  main(){
        playNavalBattle();
    }



    static void playNavalBattle(){
        int[][] playerBoard = new int[9][9];
        int[][] cpuBoard = {
                {0, 0, 1, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 1, 0, 3, 3, 3, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 4, 4, 4, 4, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 2, 0, 0, 0, 0},
                {2, 0, 0, 0, 2, 0, 3, 3, 3},
        };

        final int oneTileShipLength = 1;
        final int twoTileShipLength = 2;
        final int threeTileShipLength = 3;
        final int fourTileShipLength = 4;

        int oneTileShipCount = 3;
        int twoTileShipCount = 2;
        int threeTileShipCount = 2;
        int fourTileShipCount = 1;

        IO.println("=========================");
        IO.println("Benvenuti a battaglia navale");
        IO.println("=========================");

        printBoard(playerBoard);
        while(oneTileShipCount + twoTileShipCount + threeTileShipCount + fourTileShipCount > 0){
            IO.println("Generale dobbiamo posizionare le navi da guerra!");
            printNavalShipToDeploy(oneTileShipLength, oneTileShipCount);
            printNavalShipToDeploy(twoTileShipLength, twoTileShipCount);
            printNavalShipToDeploy(threeTileShipLength, threeTileShipCount);
            printNavalShipToDeploy(fourTileShipLength, fourTileShipCount);

            int shipLength;
            boolean isShipAvailable = false;
            do{
                shipLength = Integer.parseInt(IO.readln("Quale nave da guerra vuoi schierare? (Inserisci il codice) "));

                switch (shipLength){
                    case 1:
                        isShipAvailable = oneTileShipCount > 0;
                        break;
                    case 2:
                        isShipAvailable = twoTileShipCount > 0;
                        break;
                    case 3:
                        isShipAvailable = threeTileShipCount > 0;
                        break;
                    case 4:
                        isShipAvailable = fourTileShipCount > 0;
                        break;
                    default:
                        IO.println("La nave di lunghezza " + shipLength +  " non è piu disponibile.");
                }
            }while(!isShipAvailable);


            int cellX;
            int cellY;
            boolean isCellAvailable = false;
            do{
                cellX = Integer.parseInt(IO.readln("Inserisci la coordinata 'x' in numero "));
                cellY = Integer.parseInt(IO.readln("Inserisci la coordinata 'y' in numero "));

                if(cellY < 9 && cellY >= 0 && cellX >= 0 && cellX < 9 && playerBoard[cellY][cellX] == 0){
                    isCellAvailable = true;
                }else{
                    IO.println("Hai inserito una coordinata non valida");
                }
            }while(!isCellAvailable);

            int[] xCoordinates = new int[shipLength];
            int[] yCoordinates = new int[shipLength];

            boolean isShipDeployed = false;

            do{
                String s = IO.readln("Vuoi cambiare coordinate? Inserisci 'y' se si");
                if(s.equalsIgnoreCase("y")){
                    isCellAvailable = false;
                    do{
                        cellX = Integer.parseInt(IO.readln("Inserisci la coordinata 'x' in numero "));
                        cellY = Integer.parseInt(IO.readln("Inserisci la coordinata 'y' in numero "));

                        if(cellY < 9 && cellY >= 0 && cellX >= 0 && cellX < 9 && playerBoard[cellY][cellX] == 0){
                            isCellAvailable = true;
                        }else{
                            IO.println("Hai inserito una coordinata non valida");
                        }
                    }while(!isCellAvailable);
                }

                xCoordinates[0] = cellX;
                yCoordinates[0] = cellY;

                if(shipLength != 1){
                    String directionString = IO.readln("""
                    Inserisci la direzione della nave:
                    _"w" diretto verso sopra
                    _"s" diretto verso sotto
                    _"a" diretto verso sinistra
                    _"d" diretto verso destra
                    """);


                    switch (directionString){
                        case "w":
                            for(int i = 1, currentYCell = cellY - 1; i < shipLength; i++, currentYCell--){
                                xCoordinates[i] = cellX;
                                yCoordinates[i] = currentYCell;
                            }
                            break;
                        case "s":
                            for(int i = 1, currentYCell = cellY + 1; i < shipLength; i++, currentYCell++){
                                xCoordinates[i] = cellX;
                                yCoordinates[i] = currentYCell;
                            }
                            break;
                        case "a":
                            for(int i = 1, currentXCell = cellX - 1; i < shipLength; i++, currentXCell--){
                                xCoordinates[i] = currentXCell;
                                yCoordinates[i] = cellY;
                            }
                            break;
                        case "d":
                            for(int i = 1, currentXCell = cellX + 1; i < shipLength; i++, currentXCell++){
                                xCoordinates[i] = currentXCell;
                                yCoordinates[i] = cellY;
                            }
                            break;
                        default:
                            IO.println("Non hai inserito una direzione valida");
                            continue;
                    }
                }


                isShipDeployed = tryInsertShip(playerBoard, xCoordinates, yCoordinates);
                if(!isShipDeployed){
                    IO.println("Errore nell'inserimento della nave. Probabile celle non disponibili");
                }
            }while(!isShipDeployed);

            switch (shipLength){
                case 1:
                    oneTileShipCount--;
                    break;
                case 2:
                    twoTileShipCount--;
                    break;
                case 3:
                    threeTileShipCount--;
                    break;
                case 4:
                    fourTileShipCount--;
                    break;
                default:
                    IO.println("Errore nella diminuzione del contatore nave.");
            }

            printBoard(playerBoard);
        }

        while(true){
            IO.println("Generale abbiamo inserito tutte le nostre navi da guerra!");
            IO.println("E' il momento di iniziare il combattimento a turno");

            int cellX = Integer.parseInt(IO.readln("Inserisci la coordinata x che vuoi attaccare: "));
            int cellY = Integer.parseInt(IO.readln("Inserisci la coordinata y che vuoi attaccare: "));

            if(cellX < 0 || cellX > 8 || cellY < 0 || cellY > 8){
                IO.println("Generale le coordinate sono sbagliate!");

            }else{
                if(cpuBoard[cellY][cellX] != 0){
                    IO.println("Bersaglio colpito!");
                    cpuBoard[cellY][cellX] = 0;
                }else{
                    IO.println("Acqua!");
                }
            }

            Random random = new Random();
            cellY = random.nextInt(9);
            cellX = random.nextInt(9);

            IO.println("=====================");
            IO.println("E' il turno del nemico");

            if(cpuBoard[cellY][cellX] != 0){
                IO.println("Bersaglio colpito!");
                cpuBoard[cellY][cellX] = 0;
            }else{
                IO.println("Acqua!");
            }
            IO.println("======Navi alleate");
            printBoard(playerBoard);
            IO.println("=======Navi nemiche");
            printBoard(cpuBoard);

            boolean isPlayerDead = isBoardEmpty(playerBoard);
            if(isPlayerDead){
                IO.println("Tutte le nostre navi sono stati distrutte. GAME OVER");
                break;
            }
            boolean isCpuDead = isBoardEmpty(cpuBoard);

            if(isCpuDead){
                IO.println("Tuttle le navi nemiche sono distrutte. WIN");
                break;
            }

        }


    }

    static void printBoard(int[][] trisMatrix){
        for (int[] matrix : trisMatrix) {
            IO.println(Arrays.toString(matrix));
        }
    }

    static boolean isBoardEmpty(int[][] shipBoard){
        for(int i = 0; i < shipBoard.length; i++){
            for(int j = 0; j < shipBoard[0].length; j++){
                if(shipBoard[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean tryInsertShip(int[][] shipBoard, int[] xCoordinates, int[] yCoordinates){
        int shipLength = xCoordinates.length;
        for(int i = 0; i < shipLength; i++){
            if(xCoordinates[i] < 0 || xCoordinates[i] > 8 || yCoordinates[i] < 0 || yCoordinates[i] > 8 || shipBoard[yCoordinates[i]][xCoordinates[i]] != 0){
                return false;
            }
        }
        for(int i = 0; i < shipLength; i++){
            shipBoard[yCoordinates[i]][xCoordinates[i]] = shipLength;
        }
        return true;

    }

    static void printNavalShipToDeploy(int shipLength, int shipCount){
        IO.println("Hai " + shipCount + " navi di lunghezza " + shipLength + " da schierare (codice " + shipLength + ")");
    }

}
