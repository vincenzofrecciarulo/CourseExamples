package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.List;

public class World {
    private Room start;
    private Room current;

    public World(){
        Item babba=new Item(1,5,"Babba napoletano");
        List<Item>ciroLoot=new ArrayList<>();
        ciroLoot.add(babba);
        List<Entity> es = new ArrayList<>();
        es.add(new Npc("Ciruzzo",
                50,
                ciroLoot,
                2,
                true,
                "Ciao wagliu come stai? ",
                "Ecco a te pigliatell nu bell "+babba.getName()));
        es.add(new Npc("Nino il nullafacente",7,2,current,"Sono un fallito"));

        List<Item> os = new ArrayList<>();
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
        String playerName= IO.readln("Inserisci il tuo nick...");
        List<Item>backpack=new ArrayList<>();
        Player player1=new Player("playerName",20,backpack,5);
        current=start;
        player1.setCurrent(start);
        while(player1.isAlive()) {
            IO.println(player1.getCurrent());
            String pickCommand;
            boolean picked;
            do {
                pickCommand = IO.readln("Vuoi prendere un item? Y/N ");
                switch (pickCommand.toLowerCase()) {
                    case "n":
                        IO.println("OK,non prenderai nessun item");
                        break;
                    case "y":
                        String itemChoice = IO.readln("Scrivi il nome dell'item da prendere ");
                        picked = player1.pickItem(itemChoice);
                        if (picked) {
                            IO.println("Item aggiunto correttamente all'inventario");
                        } else {
                            IO.println("Item non trovato");
                        }
                        break;
                    default:
                        IO.println("Errore scegli tra Y/N");
                }
            } while (!pickCommand.equalsIgnoreCase("N") && !player1.getCurrent().getItems().isEmpty());

            String dropCommand;
            boolean isDropped=false;
            if(player1.getItems().isEmpty()) {
                IO.println("Il tuo zaino è vuoto");
            }else{
                do {
                    dropCommand = IO.readln("Vuoi droppare un item? Y/N");
                    switch (dropCommand.toLowerCase()) {
                        case "n":
                            break;
                        case "y":
                            IO.println(player1.getItems());
                            isDropped=player1.dropItem();
                            if(isDropped){
                                IO.println("Item droppato con successo");
                            }
                            break;
                        default:
                            IO.println("Errore digita Y/N");
                    }
                } while (!dropCommand.equalsIgnoreCase("Y") && !dropCommand.equalsIgnoreCase("N"));
            }


           if(!player1.getCurrent().getEntities().isEmpty()){
               boolean isValid=false;
               do{
                   String npcInput=IO.readln("Vuoi parlare con qualcuno? Y/N");
                   switch(npcInput.toLowerCase()) {
                   case "n":
                       isValid=true;
                       break;
                   case "y":
                       player1.talkToNpc();
                       isValid=true;
                       break;
                   default:
                       IO.println("Errore devi scegliere tra Y/N");
                       break;
               }
               }while(!isValid);
           }






            String directionCommand = IO.readln("Scegli la direzione->");
            boolean success = false;
            switch (directionCommand.toLowerCase()) {
                case "n":
                    success = moveTo(Room.NORTH, player1);
                    break;
                case "e":
                    success = moveTo(Room.EAST, player1);
                    break;
                case "w":
                    success = moveTo(Room.WEST, player1);
                    break;
                case "s":
                    success = moveTo(Room.SOUTH, player1);
                    break;
                case "q":
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito che cosa vuoi!");
                    continue;

            }
            if (success) {
                IO.println("Te ne vai a " + directionCommand);
            } else {
                IO.println("Non c'è nulla in quella direzione");
            }
        }
    }

    private boolean moveTo(int direction,Player player1) {
        Room destination = current.exitAt(direction);
        if(destination != null){
            current = destination;
            player1.setCurrent(current);
            return true;
        }
        return false;
    }

    public void main(){
        World w = new World();
        w.startGame();
    }
}