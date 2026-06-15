package org.generation.italy.examples.oo.battleShip;

public class Start {
    static void main() {
        Player p1= new Player(IO.readln("Inserire il nome del player 1: "));
        Player p2= new Player(IO.readln("Inserire il nome del player 2: "));

        IO.println("Player "+p1.getName()+" posiziona le tue navi\n\n");
        setUpGrid(p1);
        clearScreen();
        IO.println("\n\nPlayer "+p2.getName()+" posiziona le sue navi\n\n");
        setUpGrid(p2);

    }
    public static void clearScreen(){IO.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");}
    public  static void setUpGrid(Player p){
        for(BoatType b : BoatType.values()) p.addBoat(b);
    }
}
