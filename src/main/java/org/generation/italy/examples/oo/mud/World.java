package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;
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
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void startGame(){
        current = start;
        while(true){
            // IO.println(current.getTitle());
            // IO.println(current.getDescription());
            IO.println(current); // questo fa automaticamente toString
            String command = IO.readln("->");
            boolean success = false;
            switch(command.toLowerCase()) {
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
                case "inventory":
                    ArrayList<Item> inventory= this.player.getInventory();
                    if (inventory.isEmpty()){
                        IO.println("mi dispiace, il tuo zaino è vuoto");
                    }else {
                        IO.println("nel tuo inventario sono presenti i seguenti oggetti:");
                        for(Item i : inventory){
                            IO.println("- "+i.getName());
                        }
                    }
                    break;
                case "q":
                    IO.println("Grazie per aver giocato");
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
        System.out.println("Benvenuto nel MUD, inserisci il nome del tuo eroe:");
        String nameSelected = IO.readln("-> ");
        System.out.println("""
                Seleziona la difficoltà: scrivi 'comandante' se ti senti un principiante e vuoi avere più possibilità
                 di infliggere danni. Se ti piacciono le sfide invece scrivi 'guerriero'. Ma in realtà puoi scrivere
                 quello che vuoi, ma a tuo rischio e pericolo...""");
        String classSelected = IO.readln("-> ");
        Player p = new Player(nameSelected, classSelected);
        w.setPlayer(p);
        w.startGame();
    }
}