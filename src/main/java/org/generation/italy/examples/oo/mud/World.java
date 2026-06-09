/*
Mostro la stanza attuale, chiedo al player cosa vuole fare, mostro l'azione corrispondente, proseguo il ciclo.
 Oggetto player con oggetto inventario, metodo pick and drop, prendo oggetti nelle stanze e li lacsio nell 'inventario
 ma posso anche lasciare oggetti in una stanza, vedere peso dell'inventario, mostri con cui combattere in alcune stanze, in caso positivo droppano oggetti
 Stanze speciali con comandi speciali (panificio compri panini per hp), temple square prete che guarisce per soldi.
 */

package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;

    public World(){
        ArrayList<Entity> es = new ArrayList<>();
//        es.add(new Entity(50, "Ciro la guardia", 7));
        ArrayList<Item> os = new ArrayList<>();
        os.add(new Item(2,10, "Bastone di legno"));
        os.add(new Item(3,9,"Scudo di ferro"));

        Room ms = new Room("Piazza del Mercato",
                """
                        Ti trovi nella Piazza del Mercato, piena di artigiani, guerrieri e fannulloni
                        """, es, os
        );
        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(4,8,"Ago di metallo"));

        Room ts = new Room("Piazza del Tempio",
                """
                        Qui vengono a curarsi gli avventurieri acciaccati
                        """, new ArrayList<>(), os2
        );

        ms.addExit(ts,Room.NORTH);
        ts.addExit(ms,Room.SOUTH);
        start = ms;
    }

    public void startGame(){
        current = start;   //Inizializziamo con la Room di inizio, poi si cambia man mano.
        while (true){
            IO.println(current);        //Stampando l'oggetto Room di nome current stiamo chiamando automaticamente il toString() che noi abbiamo sovrascritto
            String command = IO.readln("->");
            boolean success = false;
            switch(command.toLowerCase()){              //.toLowerCase fa sì che se anche l'utente inserisce in maiuscolo, questo metodo lo converte in minuscolo.
                case "n" :
                    success = moveTo(Room.NORTH);
                    break;
                case "e" :
                    success = moveTo(Room.EAST);
                    break;
                case "w" :
                    success = moveTo(Room.WEST);
                    break;
                case "s" :
                    success = moveTo(Room.SOUTH);
                    break;
                case "q" :
                    IO.println("Grazie per aver giocato");
                    return;
                default :
                    IO.println("Non ho capito cosa vuoi...");
                    continue;


            }
            if (success) {
                IO.println("Te ne vai a: " + command);
            } else {
                IO.println("Non c'è nulla in quella direzione...");
            }

        }
    }

    private boolean moveTo(int direction){
        Room destination = current.exitAt(direction);
        if (destination != null) {
            current = destination;
            return true;
        }
        return false;
    }

    public static void main() {
        World w = new World();
        w.startGame();
    }
}
