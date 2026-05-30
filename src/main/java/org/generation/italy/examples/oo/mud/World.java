package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.rooms.EmptyRoom;
import org.generation.italy.examples.oo.mud.rooms.MarketRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;
import org.generation.italy.examples.oo.mud.rooms.TempleRoom;

public class World {
    public final static Room start = new TempleRoom();
    private final Player player;

    public World(){
        //es.add(new Entity(50, "Ciro la Guardia", 7));
        //os.add(new Item(2, 10, "Bastone di legno"));
        //os.add(new Item(3, 9, "Scudo di ferro"));
        //os2.add(new Item(4, 8, "Ago di metallo"));
        // stanza del tempio

        start.addExit(new MarketRoom(), Room.NORTH);
        start.addExit(new EmptyRoom(), Room.SOUTH);
        start.addExit(new EmptyRoom(), Room.WEST);
        start.addExit(new EmptyRoom(), Room.EAST);
        player = new Player(100, "Player", 1, start, 100, new Inventory());
    }

    public void startGame(){
        while(true){
            IO.println(player.getCurrentRoom()); // questo fa automaticamente toString
            String command = IO.readln("->");
            switch(command.toLowerCase()) {
                case "w":
                    moveTo(player, Room.NORTH);
                    break;
                case "d":
                    moveTo(player, Room.EAST);
                    break;
                case "a":
                    moveTo(player, Room.WEST);
                    break;
                case "s":
                    moveTo(player, Room.SOUTH);
                    break;
                case "x":
                    player.interact();
                    break;
                case "q":
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito che cosa vuoi!");
                    IO.println("--------------Next---------------");
                    continue;
            }

            IO.println("--------------Next---------------");
        }
    }

    public void moveTo(Player player, int direction){
        if(!player.tryMoveTo(direction)){
            IO.println("""
            Non c'è niente in quella direzione...
            🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
             🧱🧱🧱🧱🧱🧱🧱🧱🧱
            🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
             🧱🧱🧱🧱🧱🧱🧱🧱🧱
            🧱🧱🧱🧱🧱🧱🧱🧱🧱🧱
            """);
        }else{
            IO.println("Stai correndo...");
        }
    }

    public void main(){
        World w = new World();
        w.startGame();
    }
}