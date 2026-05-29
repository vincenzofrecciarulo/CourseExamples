package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.rooms.MarketRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;
import org.generation.italy.examples.oo.mud.rooms.TempleRoom;

import java.util.ArrayList;

public class World {
    public final static Room start = new TempleRoom();
    private final Player player;

    public World(){
        //es.add(new Entity(50, "Ciro la Guardia", 7));
        //os.add(new Item(2, 10, "Bastone di legno"));
        //os.add(new Item(3, 9, "Scudo di ferro"));
        //os2.add(new Item(4, 8, "Ago di metallo"));
        // stanza del tempio

        Room market = new MarketRoom();
        start.addExit(market, Room.NORTH);
        market.addExit(start, Room.SOUTH);
        player = new Player(100, "Player", 1, start);
    }

    public void startGame(){
        while(true){
            // IO.println(current.getTitle());
            // IO.println(current.getDescription());
            IO.println(player.getCurrentRoom()); // questo fa automaticamente toString
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
                case "q":
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito che cosa vuoi!");
                    IO.println("--------------Next---------------");
                    continue;
            }

            if (success){
                IO.println("Te ne vai a " + command);
            }else{
                IO.println("Non c'è nulla in quella direzione");
            }
            IO.println("--------------Next---------------");
        }
    }

    private boolean moveTo(int direction) {
        Room destination = player.getCurrentRoom().exitAt(direction);
        if(destination != null){
            player.setCurrentRoom(destination);
            return true;
        }
        return false;
    }

    public void main(){
        World w = new World();
        w.startGame();
    }
}