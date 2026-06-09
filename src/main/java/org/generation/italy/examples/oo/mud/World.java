package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;

    private Player player;


    public World(){

        ArrayList<Entity> es = new ArrayList<>();

        NPC ciro = new NPC(50, "Ciro la Guardia", 7, 5, 6, "Benvenuto in città!");
        player = new Player(100, "Haru", 1, 3, 2);

        ArrayList<Item> os = new ArrayList<>();

        os.add(new Item(2, 10, "Bastone di legno"));
        os.add(new Item(3, 9, "Scudo di legno"));

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
        while(true){
            // IO.println(current.getTitle());
            // IO.println(current.getDescription());
            System.out.println("Benvenuto "+player.getName()+", il tuo livello attuale è "+player.getLevel());
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
                case "attack":
                    ArrayList<Entity> enemies = current.getEnemies();
                    if(enemies.isEmpty()) {
                        System.out.print("Non ci sono nemici presenti nella stanza.");
                        return;
                    }
                    else{
                        for (int i = 0; i < enemies.size(); i++) {
                            System.out.println(i + " - " + enemies.get(i).getName());
                        }
                        String input = IO.readln("Chi vuoi attaccare?");
                        int index = Integer.parseInt(input);
                        Entity target = enemies.get(index);
                        DiceRoller dice = new DiceRoller();
                        int roll = dice.rollD20();
                        int total = roll + player.getAttack();

                        if (total >= target.getDefense()) {
                            int damage = dice.rollD6() + player.getAttack();
                            target.takeDamage(damage);
                            if (target.getHp() == 0) {
                                current.getEnemies().remove(target);
                                System.out.println(target.getName() + " è stato sconfitto!");
                            }

                        } else {
                            System.out.println("Mancato!");
                        }
                    }
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

}