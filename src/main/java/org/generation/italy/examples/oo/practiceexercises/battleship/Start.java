package org.generation.italy.examples.oo.practiceexercises.battleship;

import java.util.Arrays;

public class Start {

    private Player player;
    private Player bot;


    public Start(Player player, Player bot) {
        this.player = player;
        this.bot = bot;
    }

    public void start(){
        IO.println("======WELCOME IN THE BATTLESHIPGAME======");
        String name=IO.readln("Insert your name...");
        Player player1=new Player(name);
        System.out.printf("Welcome,%s ,are u ready??",name);
        for(Boat b: player1.getBoats()){
           String[]coordinate=getCoordinate();
           char dir=getDirection();
           char row =getRow(coordinate);
           int col=getCol(coordinate);
           player1.getPlayerGrid().chooseDirectionAndPlaceBoat(b.getType(),dir,row,col);
        }


    }
    public String[] getCoordinate(){
        String rowString="";
        String colString="";
        boolean validPosition=false;
        while(!validPosition) {
            rowString = IO.readln("Choose your row.. ex(A-J)");
            colString = IO.readln("Chose your column..ex(1-10");

            try {
                int col=Integer.parseInt(colString);
                char row=rowString.charAt(0);
                if(row>= 'A' && row<= 'J' && col >= 1 && col<=10){
                    validPosition=true;
                }else {
                    IO.println("ERROR WRONG INPUT");
                }
            }catch(Exception e){
                IO.println("WRONG INPUT,ERROR");
            }

        }
        return new String[]{rowString,colString};
    }

    public char getDirection() {
        boolean validDirection = false;
        char dir='N';
        while (!validDirection) {
            String d = IO.readln("Choose direction H/V..");
            if(d.equalsIgnoreCase("H")||d.equalsIgnoreCase("V")){
                validDirection=true;
                dir=d.charAt(0);
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
