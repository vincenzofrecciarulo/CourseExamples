package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;

    public World() {
        ArrayList<Entity> es = new ArrayList<>();
        es.add(new Entity(50,"Ciro la guardia", 7));
        ArrayList<Item> os = new ArrayList<>();
        os.add(new Item(2, 10, "Bastone di legno"));
        os.add(new Item(3, 9, "Scudo di ferro"));

        Room ms = new Room("Piazza del mercato",
                """
                          Ti trovi nella Piazza del mercato piena di artigiani
                          fannulloni...
                          """, es, os);

        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(4, 8, "Ago di metallo"));

        Room ts = new Room("Stanza del tempio",
                """
                        Qui vengono a curarsi gli avventurieri malati!
                        """, new ArrayList<>(), os2);

        ms.addExit(ts, Room.NORTH);
        ts.addExit(ms, Room.SOUTH);
        start = ms;
    }

    public void startGame() {
        current = start;
        Player p1 = new Player(100,"Pippo",10,current);
        while (true) {
            IO.println(current);
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
                case "i":
                   p1.openInventory();
                   break;
                case "p":
                    p1.pickItem(current.getItems().getFirst());
                    break;
                case "d":
                    p1.dropItem(p1.getInventory().getFirst());
                    break;
                case "q":
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito cosa vuoi.");
                    continue;
            }
            if (success) {
                IO.println("Te ne vai a "+command);
            } else {
                IO.println("Non c'e' nulla");
            }
        }
    }

        private boolean moveTo(int direction) {
            Room destination = current.exitAt(direction);
            if (destination!=null) {
                current=destination;
                return true;
            }
            return false;
        }

        public void main() {
        World w = new World();
        w.startGame();
        }
}
