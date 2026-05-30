package org.generation.italy.examples.oo.mud;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;



    public World(){
        ArrayList<Entity> es = new ArrayList<>();
        es.add(new Entity(50, "Ciro la Guardia", 7));

        ArrayList<Item> os = new ArrayList<>();
        os.add(new Item(2, 10, "Bastone di legno"));
        os.add(new Item(3, 9, "Scudo di ferro"));

        Room ms = new Room("Piazza del Mercato",
                """
                        Ti trovi nella Piazza del Mercato piena di artigiani e fannulloni!
                        """, es, os
        );

        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(4, 8, "Ago di metallo"));

        // stanza del tempio
        Room ts = new Room("Piazza del Tempio",
                """
                        Qui vengono a curarsi gli avventurieri malati!
                        """, new ArrayList<>(), os2
        );

        ms.addExit(ts, Room.NORTH);
        ts.addExit(ms, Room.SOUTH);
        start = ms;
    }

    public void startGame(){
        current = start;
        Player p1 = new Player(100,"Banana",10,current);
        boolean newRoom = true;
        while(true){
            // IO.println(current.getTitle());
            // IO.println(current.getDescription());
            if (newRoom) {
                IO.println(current.toString());// questo fa automaticamente toString
                newRoom = false;
            }
            System.out.println("Che cosa desideri fare? ");
            System.out.println("I: Accedi all'inventario \n M: muoviti. \n" +
                    "E: Esplora la zona \n Q: Esci dal gioco.");
            String chioce = IO.readln("->");
            switch (chioce.toLowerCase()) {
                case "i":
                    p1.openInventory();
                    break;
                case "m":
                    System.out.println("Dove ti vuoi dirigere?");
                    System.out.println("N: a Nord \n E: a Est \n S: a Sud \n W: a Ovest");
                    String command = IO.readln("->");
                    boolean success = false;
                    switch (command.toLowerCase()) {
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
                            IO.println("Non ho capito dove vuoi andare!");
                            continue;
                    }
                    if (success){
                        newRoom = true;
                    }else{
                        IO.println("Non c'è nulla in quella direzione");
                        break;
                    } break;
                case "e":
                    IO.println(current.infoRoom());
                    break;
                case "q":
                    IO.println("Grazie per aver giocato");
                    return;
            }
        }
    }

    private boolean moveTo(int direction) {
        Room destination = current.exitAt(direction);
        if(destination != null){
            current = destination;
            return true;
        }
        return false;
    }

    public void main(){
        World w = new World();
        w.startGame();




    }



}