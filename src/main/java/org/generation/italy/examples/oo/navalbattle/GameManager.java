package org.generation.italy.examples.oo.navalbattle;

import org.generation.italy.examples.oo.navalbattle.enums.BoatSize;
import org.generation.italy.examples.oo.navalbattle.enums.Direction;

public class GameManager {
    private Board playerBoard;
    private Board enemyBoard;

    private Player player;

    public GameManager(){
        player = new Player();
        playerBoard = new Board();
        enemyBoard = new Board();
    }

    public void startGame(){
        IO.println("Benvenuto a battaglia navale");

        //Fase di inserimento nave
        insertBoatPhase(player, playerBoard);

    }

    private void insertBoatPhase(Player p, Board board){
        IO.println((int)'3');
        while(!p.areAllBoatsDeployed()){
            board.printBoard();
            p.askToDeployBoat();
            int length = Integer.parseInt(IO.readln("Inserisci il codice della nave da schierare: "));
            boolean isBoatAvailable;

            try{
                isBoatAvailable = p.isBoatAvailable(BoatSize.getBoatSize(length));
            }catch (Exception e){
                IO.println("Nave non disponibile o codice non valido");
                continue;
            }

            if(!isBoatAvailable){
                IO.println("Nave non disponibile o codice non valido");
                continue;
            }

            Coordinate coordinate = null;

            while(coordinate == null){
                try{
                    coordinate = askCoordinate();
                }catch (Exception e){
                    IO.println("Coordinate non valide");
                }

            }

            Direction direction = null;
            while(direction == null){
                String directionString = IO.readln("""
                    Inserisci la direzione:
                    - 'n' Nord
                    - 's' Sud
                    - 'e' Est
                    - 'o' Ovest
                    
                    """).trim();

                try{
                    direction = Direction.getDirection(directionString.charAt(0));
                }catch (Exception e){
                    IO.println("Direzione non valida");
                }
            }

            try{
                board.tryAddBoat(p, coordinate, length, direction);
            }catch (Exception e){
                IO.println("Alcune caselle sono già occupate");
                continue;
            }
            IO.println("Nave aggiunta con successo");
        }
    }


    private Coordinate askCoordinate() throws Exception {
        String coordinateString = IO.readln("Inserisci le coordinate (es. A3) : ").trim();
        int y;
        int x;

        y = coordinateString.charAt(0) - 65;
        x = coordinateString.charAt(1) - '0';


        IO.println(x+ " " + y);
        return new Coordinate(x,y);
    }
}
