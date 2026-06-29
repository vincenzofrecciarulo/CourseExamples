package org.generation.italy.examples.oo.practiceexercises.battleship;

import java.util.ArrayList;
import java.util.List;

public class Start {

    private Player player;
    private Player bot;


    public void start(){
        IO.println("======WELCOME IN THE BATTLESHIPGAME======");
        String name=IO.readln("Insert your name...");
        List<Boat>boats=new ArrayList<>();
        Grid playerGrid=new Grid();
        Player player1=new Player(name,boats,playerGrid);
        player1.setPlayerGrid(playerGrid);
        System.out.printf("Welcome,%s ,are u ready??%n",name);
            for(Boat b: player1.getBoats()) {
                player1.getPlayerGrid().printBattleCamp();
                String[] coordinate = getCoordinate();
                String dir = getDirection().toString();
                char row = getRow(coordinate);
                int col = getCol(coordinate);
                player1.getPlayerGrid().placeBoat(player1, b.getType(), dir, row, col);
        }
    }
    public String[] getCoordinate(){
        String rowString="";
        String colString="";
        boolean validPosition=false;
        while(!validPosition) {
            rowString = IO.readln("Choose your row.. ex(A-J)");
            colString = IO.readln("Chose your column..ex(1-10)");
            try {
                int col=Integer.parseInt(colString);
                char row=rowString.toUpperCase().charAt(0);
                if(row >= 'A' && row<= 'J' && col >= 1 && col<=10){
                    validPosition=true;
                }else {
                    IO.println("ERROR WRONG INPUT");
                }
            }catch(Exception e){
                IO.println("WRONG INPUT,ERROR");
            }

        }
        return new String[]{rowString.toUpperCase(),colString};
    }

    public Object getDirection() {
        boolean validDirection = false;
        String dir="N";
        while (!validDirection) {
            String d = IO.readln("Choose direction H/V..");
            if(d.equalsIgnoreCase("H")||d.equalsIgnoreCase("V")){
                validDirection=true;
                dir= String.valueOf(d.charAt(0));
            }else{
                IO.println("INVALID DIRECTION,RETRY..");
            }
        }
        return dir;
    }

    public char getRow(String[] part){
        return part[0].charAt(0);
    }
    public int getCol(String[]part){
        return Integer.parseInt(part[1]);
    }
}

