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
        player = new Player(100, "Player", 1, start, 100);
    }

    public void startGame(){
        while(true){
            IO.println(player.getCurrentRoom()); // questo fa automaticamente toString
            String command = IO.readln("->");
            boolean isMoveSuccess;
            switch(command.toLowerCase()) {
                case "w":
                    isMoveSuccess = player.tryMoveTo(Room.NORTH);
                    if(!isMoveSuccess){
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
                    break;
                case "d":
                    isMoveSuccess = player.tryMoveTo(Room.EAST);
                    if(!isMoveSuccess){
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
                    break;
                case "a":
                    isMoveSuccess = player.tryMoveTo(Room.WEST);
                    if(!isMoveSuccess){
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
                    break;
                case "s":
                    isMoveSuccess = player.tryMoveTo(Room.SOUTH);
                    if(!isMoveSuccess){
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



    public void main(){
        World w = new World();
        w.startGame();
    }
}