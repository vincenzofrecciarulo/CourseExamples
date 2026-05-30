package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Player player;

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
        player = new Player(50,"Jacopo",1,start);
    }

    public void startGame(){
        while(true){
            IO.println(player.getCurrentRoom()); // questo fa automaticamente toString della Room
            IO.println("1: muoverti");
            IO.println("2: raccogliere oggetti");
            IO.println("3: vedere l'inventario");
            IO.println("4: combattere");
            IO.println("5: esci dal gioco");
            String command = IO.readln("Cosa vuoi fare?");
            int userInput = Integer.parseInt(command);
            switch(userInput) {
                case 1:
                        playerMove();
                    break;
                case 2:
                        managePlayerPick();
                    break;
                case 3:
                        player.inventoryToString();
                    break;
                case 4:
                        IO.println("Non abbiamo ancora un sistema di combattimento :(");
                    break;
                case 5:
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito che cosa vuoi!");
            }
        }
    }

    public void managePlayerPick(){
        Room currentRoom = player.getCurrentRoom();
        boolean isRoomEmpty = currentRoom.getObjectNames().isEmpty();
        if (isRoomEmpty){
            IO.println("Nessun oggetto nella stanza");
            return;
        }
        IO.println("Scegli l'oggetto da prendere ->");
        currentRoom.itemsToString();
        int input = Integer.parseInt(IO.readln("scrivi l'indice del oggetto che vuoi aggiungere"));
        IO.println(player.pick(input));
    }

    public void playerMove(){
        while(true){
            String command = IO.readln("Dove vuoi andare ->");
            boolean success = false;
            switch(command.toLowerCase()) {
                case "n":
                    success = player.moveTo(Room.NORTH);
                    break;
                case "e":
                    success = player.moveTo(Room.EAST);
                    break;
                case "w":
                    success = player.moveTo(Room.WEST);
                    break;
                case "s":
                    success = player.moveTo(Room.SOUTH);
                    break;
                case "q":
                    IO.println("Non ti muovi");
                    return;
                default:
                    IO.println("Non ho capito che cosa vuoi!");
                    continue;
            }

            if (success){
                IO.println("Te ne vai a " + command);
            }else{
                IO.println("Non c'è nulla in quella direzione");
            }
        }
    }

    public void main(){
        World w = new World();
        w.startGame();
    }
}