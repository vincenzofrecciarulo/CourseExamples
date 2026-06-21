package org.generation.italy.examples.oo.navalbattle;

import org.generation.italy.examples.oo.navalbattle.enums.Direction;

import java.util.Map;

public class Board {
    private Boat[][] board;
    private static final int BOARD_SIZE = 8;

    public static final Map<Integer, Character> columnMapNumberAsKey = Map.of(
            0,'A',
            1,'B',
            2,'C',
            3,'D',
            4,'E',
            5,'F',
            6,'G',
            7,'H'
    );

    public Board() {
        this.board = new  Boat[BOARD_SIZE][BOARD_SIZE];
    }

    public void tryAddBoat(Player player, Coordinate coordinate, int boatLength, Direction direction) throws Exception {
        if(board[coordinate.getY()][coordinate.getX()] != null){
            throw new Exception();
        }

        switch (direction){
            case NORTH: {
                    for(int i = 0; i < boatLength - 1; i++){
                        if(board[coordinate.getY() - i][coordinate.getX()] != null){
                            throw new Exception();
                        }
                    }
                    Boat boat = new Boat();
                    boat.addCoordinate(new Coordinate(coordinate.getX(), coordinate.getY()));
                    for(int i = 0; i < boatLength - 1; i++){
                       boat.addCoordinate(new Coordinate(coordinate.getX(), coordinate.getY() - i));
                       board[coordinate.getY() - i][coordinate.getX()] = boat;
                    }
                    player.addBoat(boat);
                }
                break;
            case SOUTH: {
                    for(int i = 0; i < boatLength - 1; i++){
                        if(board[coordinate.getY() + i][coordinate.getX()] != null){
                            throw new Exception();
                        }
                    }
                    Boat boat = new Boat();
                    boat.addCoordinate(new Coordinate(coordinate.getX(), coordinate.getY()));
                    for(int i = 0; i < boatLength - 1; i++){
                        boat.addCoordinate(new Coordinate(coordinate.getX(), coordinate.getY() + i));
                        board[coordinate.getY() + i][coordinate.getX()] = boat;
                    }
                    player.addBoat(boat);
                }
                break;
            case EAST: {
                    for(int i = 0; i < boatLength - 1; i++){
                        if(board[coordinate.getY()][coordinate.getX() + i] != null){
                            throw new Exception();
                        }

                    }
                    Boat boat = new Boat();
                    boat.addCoordinate(new Coordinate(coordinate.getX(), coordinate.getY()));
                    for(int i = 0; i < boatLength - 1; i++){
                        boat.addCoordinate(new Coordinate(coordinate.getX() + i, coordinate.getY()));
                        board[coordinate.getY()][coordinate.getX() + i] = boat;
                    }
                    player.addBoat(boat);
                }
                break;
            case WEST: {
                    for(int i = 0; i < boatLength - 1; i++){
                        if(board[coordinate.getY()][coordinate.getX() - i] != null){
                            throw new Exception();
                        }
                    }
                    Boat boat = new Boat();
                    boat.addCoordinate(new Coordinate(coordinate.getX(), coordinate.getY()));
                    for(int i = 0; i < boatLength - 1; i++){
                        boat.addCoordinate(new Coordinate(coordinate.getX() - i, coordinate.getY()));
                        board[coordinate.getY()][coordinate.getX() - i] = boat;
                    }
                    player.addBoat(boat);
                }
                break;
            default:
                break;
        }
    }


    public void printBoard(){
        IO.println("    1  2  3  4  5  6  7  8");
        for(int i = 0; i < BOARD_SIZE; i++){
            IO.print(" " + columnMapNumberAsKey.get(i) + " ");
            for(int j = 0; j < BOARD_SIZE; j++){
                if(board[i][j] == null){
                    IO.print(" - ");
                }else{
                    IO.print(" B ");
                }
            }
            IO.println("");
        }
    }

}
