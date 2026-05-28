package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;

    public World(){
        ArrayList<Entity> es = new ArrayList<>();
        es.add(new Entity(50, "Ciro La Guardia", 7));
        ArrayList<Item> os = new ArrayList<>();
        os.add(new Item("Bastone di legno", 10, 2));
        os.add(new Item("scudo di ferro", 9, 3));
        Room ms = new Room("Piazza mercato",
                """
                        Ti trovi nella piazza del mercato,
                        piena di artigiani, mercanti e 
                        perdigiorno!
                        """, es,
                os);
        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item("Ago di metallo", 8, 4));
        Room ts = new Room ( "Piazza del tempio",
                """
                        Ti trovi nella piazza del tempio,
                        qui vengono a curarsi gli avventurieri
                        acciaccati
                        """, new ArrayList<>(), os2);
        ms.addExit(ts, Room.NORTH);
        ts.addExit(ms, Room.SOUTH);
        start = ms;
    }
    public void startGame(){
        current = start;
        while(true){
            IO.println(current);
            String command = IO.readln("Dove vuoi andare?\n->");
            boolean success = false;
            switch (command.toLowerCase()){
                case "n":
                    success = moveTo(Room.NORTH);
                    break;
                case "e":
                    success = moveTo(Room.EAST);
                    break;
                case "w":
                    success = moveTo(Room.WEST);
                    break;
                case "s":
                    success = moveTo(Room.SOUTH);
                    break;
                case "q":
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito, cosa vuoi\n->");
                    continue;
            }
            if (success){
                IO.println("Te ne vai a " + command);
            } else {
                IO.println("Non c'è nulla in quella direzione");
            }
        }
    }
    private boolean moveTo(int direction){
        Room destination = current.exitAt(direction);
        if(destination != null){
            current = destination;
            return true;
        }
        return false;
    }

    public void main() {
        World w = new World();
        w.startGame();
    }
}
