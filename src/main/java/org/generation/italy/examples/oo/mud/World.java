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
                "Ciao wagliu come stai? ",
                2,
                true,
                "Ecco a te pigliatell nu bell "+babba.getName()));
        es.add(new Npc("Nino il nullafacente",7,"Sono un fallito",2,current));

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
        Player player1=new Player("playerName",20,backpack,"Sono pronto a tutto!!",5);
        current=start;
        player1.setCurrent(start);
        while(player1.isAlive()) {
            IO.println(player1.getCurrent());
            IO.println(current);
            String playerCommand = IO.readln("Cosa vuoi fare?");
            do {
                switch (playerCommand.toLowerCase()) {
                    case "pick":
                        String itemChoice = "";
                        boolean hasPicked;
                        do {
                            if (player1.getCurrent().getItems().isEmpty()) {
                                IO.println("Non puoi pija nulla");
                                break;
                            }
                            IO.println("Qui ci sono"+current.getObjectNames());
                            itemChoice = IO.readln("Scrivi il nome dell'item da prendere ");
                            hasPicked = player1.pickItem(itemChoice);
                            if (hasPicked) {
                                IO.println("Item aggiunto correttamente all'inventario");
                                break;
                            } else {
                                IO.println("Item non trovato");
                            }
                        } while (itemChoice.equalsIgnoreCase("quit"));
                        player1.pickItem(itemChoice);
                        break;

                    case "drop":
                        String itemDropped;
                        boolean hasDropped = false;
                        if(player1.getItems().isEmpty()){
                            IO.println("Il tuo zaino è vuoto");
                            break;
                        }else {
                            do {
                                IO.println(player1.getItems());
                                itemDropped=IO.readln("Ecco il tuo zaino,cosa vuoi droppare?" );
                                hasDropped=player1.dropItem(itemDropped);
                            }while(!itemDropped.equalsIgnoreCase("quit")&&!hasDropped);
                            break;
                        }

                    case "move":
                        String directionCommand;
                        do {
                            directionCommand = IO.readln("Scegli la direzione->");
                            boolean success;
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
                                default:
                                    IO.println("Non ho capito che cosa vuoi!");
                                    continue;
                            }
                            if (success) {
                                IO.println("Te ne vai a " + directionCommand);
                            } else {
                                IO.println("Non c'è nulla in quella direzione");
                            }
                        }while(directionCommand.equalsIgnoreCase("quit"));
                        break;

                    case "talk":
                        boolean hasTalked = false;
                        if(player1.getCurrent().getEntities().isEmpty()){
                            IO.println("Non c'è nessuno al massimo puoi parlare da solo!!");
                            break;
                        }
                        else if(player1.getCurrent().getEntities().size()==1){
                            Entity target=player1.getCurrent().getEntities().getFirst();
                            hasTalked=player1.talkTo(target);
                        }else {
                            IO.println("Ci sono "+player1.getCurrent().getEntityNames());
                            String entityChosed;
                            do{
                                entityChosed=IO.readln("Con chi vuoi parlare?");
                                Entity found =player1.getCurrent().findEntity(entityChosed);
                                if(found!=null){
                                   hasTalked=player1.talkTo(found);
                                }else{
                                    IO.println(("Non ho capito chi cerchi!!"));
                                }
                            }while(!hasTalked&&!entityChosed.equalsIgnoreCase("quit"));
                            break;
                        }

                    case "attack":
                        boolean hasAttacked=false;
                        if(player1.getCurrent().getEntities().isEmpty()){
                            IO.println("Non c'è nessuno da attaccare");
                            break;
                        }else if(player1.getCurrent().getEntities().size()==1){
                            Entity found=player1.getCurrent().getEntities().getFirst();
                            while(player1.isAlive()&&found.isAlive()){
                                player1.attack(found);
                                found.attack(player1);
                            }
                        }else {
                            String entityAttacked;
                            do {
                                IO.println(player1.getCurrent().getEntityNames());
                                entityAttacked=IO.readln("Chi attacchi tra questi?");
                                Entity found=player1.getCurrent().findEntity(entityAttacked);
                                if(found!=null){
                                    while(player1.isAlive()&&found.isAlive()){
                                        player1.attack(found);
                                        found.attack(player1);
                                    }
                                }else {
                                    IO.println("Non ho capito chi voi mena..");
                                }

                            }while(!entityAttacked.equalsIgnoreCase("quit"));
                            break;


                        }
                }
            }while(true);


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



}