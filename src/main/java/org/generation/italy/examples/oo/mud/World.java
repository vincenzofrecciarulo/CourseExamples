package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;

    public World(){
        Item babba=new Item(1,5,"Babba napoletano");
        ArrayList<Entity> es = new ArrayList<>();
        es.add(new Npc("Ciro la Guardia",
                50,
                7,
                true,
                 babba,
                "Ciao wagliu come stai? ",
                "Ecco a te pigliatell nu bell "+babba.getName()));
        Item affilaSpade=new Item(3,10,"Affilatore di Spade");
        es.add(new Npc("Luca il fabbro",
                50,
                7,
                true,
                affilaSpade,
                "Ciao avventuriero,come mai da queste parti? ",
                "Prendi questo ti sarà utile"+affilaSpade.getName()));

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
        Player player1=new Player("Daniele");
        current=start;
        player1.setCurrent(start);
        while(true) {
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
            if(player1.getBackpack().isEmpty()) {
                IO.println("Il tuo zaino è vuoto");
            }else{
                do {
                    dropCommand = IO.readln("Vuoi droppare un item? Y/N");
                    switch (dropCommand.toLowerCase()) {
                        case "n":
                            break;
                        case "y":
                            IO.println(player1.getBackpack());
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