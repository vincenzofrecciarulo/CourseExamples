package org.generation.italy.examples.homework;

import java.util.Arrays;

public class Exercise11 {
    /*
    11) Crea una semplice implementazione di gioco di battaglia navale in cui il giocatore gioca contro il computer.
     */

    static void playNavalBattle(){
        int[][] playerBoard = new int[9][9];
        int[][] cpuBoard = new int[9][9];

        final int oneTileShipLength = 1;
        final int twoTileShipLength = 2;
        final int threeTileShipLength = 3;
        final int fourTileShipLength = 4;

        int oneTileShipCount = 5;
        int twoTileShipCount = 3;
        int threeTileShipCount = 2;
        int fourTileShipCount = 1;

        IO.println("=========================");
        IO.println("Benvenuti a battaglia navale");
        IO.println("=========================");


        while(true){
            printBoard(playerBoard);

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

                if(playerBoard[cellY][cellX] == 0){
                    isCellAvailable = true;
                }
            }while(!isCellAvailable);

            Direction direction = null;
            do{
                String directionString = IO.readln("""
                    Inserisci la direzione della nave:
                    _"w" diretto verso sopra
                    _"s" diretto verso sotto
                    _"a" diretto verso sinistra
                    _"d" diretto verso destra
                    """);


                switch (directionString){
                    case "w":
                        direction = Direction.UP;
                        break;
                    case "s":
                        direction = Direction.DOWN;
                        break;
                    case "a":
                        direction = Direction.LEFT;
                        break;
                    case "d":
                        direction = Direction.RIGHT;
                        break;
                    default:
                        IO.println("Non hai inserito una direzione valida");
                }
            }while(direction == null);

            boolean isShipDeployed = tryInsertShip(playerBoard, direction, shipLength, cellX, cellY);



        }

    }

    static void printBoard(int[][] trisMatrix){
        for (int[] matrix : trisMatrix) {
            IO.println(Arrays.toString(matrix));
        }
    }

    static boolean tryInsertShip(int[][] shipBoard, Direction direction, int shipLength, int cellX, int cellY){
        return false;
    }

    static void printNavalShipToDeploy(int shipLength, int shipCount){
        IO.println("Hai " + shipCount + shipLength + " da schierare (codice " + shipLength + ")");
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
