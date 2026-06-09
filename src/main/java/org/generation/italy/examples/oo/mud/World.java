package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;    // our starting room
    private Room current;
    private Player player;

    public World() {    // we create some rooms at the start of the game. this is the class Constructor
        ArrayList<Entity> es = new ArrayList<>();
        es.add(new Entity(50, "Ciro the surveillance guard", 8));

        ArrayList<Item> os = new ArrayList<>();
        os.add(new Item(2, 10, "Wooden Club"));
        os.add(new Item(5, 20, "Bronze Sword"));

        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(10, 30, "Iron Sword"));

        Room ms = new Room(       // market square
                "Market Square",
                """
                        You're in the Market Square, full of
                        artisans and jocks!
                        """,
                es,
                os);

        Room ts = new Room(       // temple square
                "Temple Square",
                """
                        You're in the Temple Square, where
                        adventurers come to relax, and clerics
                        wander around with old worn out books in
                        their hands...
                        """,
                new ArrayList<>(),    // no entities in this room
                os2                   // items
        );

        ms.addExit(ts, Room.NORTH);  // we link our two rooms!
        ts.addExit(ms, Room.SOUTH);
        start = ms;                  // world starts in market square
    }

    public void startGame() {
        String name = IO.readln("What's your name, adventurer? ");
        player = new Player(name);
        current = start;
        while(true) {  // mostro descrizione stanza, chiedo azione, compio e ricomincio il loop
//            IO.println(current.getTitle());
//            IO.println(current.getDescription());
            IO.println(current);  // it automatically does current.toString
            String command = IO.readln("-> ");
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
                    IO.println("Thanks for playing! ");
                    return;
                default:
                    if (command.startsWith("pick ")) {
                        String itemName = command.substring(5).trim();
                        Item item = current.findItem(itemName);
                        if (item == null) {
                            IO.println("I didn't quite understand what you want to do...");
                            continue;
                        } else {
                            player.getInventory().addItem(item);
                            current.removeItem(item);
                            continue;
                        }
                    } else if (command.startsWith("drop ")) {
                        String itemName = command.substring(5).trim();
                        Item item = player.getInventory().findItem(itemName);
                        if (item == null) {
                            IO.println("I didn't quite understand what you want to do...");
                        } else {
                            current.addItem(item);
                            player.getInventory().removeItem(item);
                        }
                        continue;
                    } else if (command.equals("inventory") || command.equals("i")) {
                        if (player.getInventory().getItemList().isEmpty()) {
                            System.out.println("Your inventory is empty!");
                        } else {
                            System.out.println(player.getInventory().getItemList()); // calls toString
                        }
                        continue;
                    } else {
                        IO.println("I didn't quite understand what you want to do...");
                        continue;
                    }
            }
            if (success) {
                IO.println("You went to " + command);   // temporary solution
            } else {
                IO.println("There's nothing in that direction... ");
            }
        }
    }

    private boolean moveTo(int direction) {
        // current was a local variable in startGame. we needed it here, so we made it a private variable of the object.
        Room destination = current.exitAt(direction);
        if (destination != null) {
            current = destination;
            return true;             // no need for an else cause of the return
        }
        return false;
    }

    public static void main(String[] args) {
        World w = new World();
        w.startGame();
    }
}
