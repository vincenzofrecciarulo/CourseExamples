package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.enums.Direction;
import org.generation.italy.examples.oo.mud.rooms.MarketRoom;
import org.generation.italy.examples.oo.mud.rooms.Room;
import org.generation.italy.examples.oo.mud.rooms.TempleRoom;


public class World {
    public final static Room start = new TempleRoom();
    public static final Map map = new Map();
    private final Player player;

    public World(){
        //es.add(new Entity(50, "Ciro la Guardia", 7));
        //os.add(new Item(2, 10, "Bastone di legno"));
        //os.add(new Item(3, 9, "Scudo di ferro"));
        //os2.add(new Item(4, 8, "Ago di metallo"));
        // stanza del tempio
        player = new Player(100, "Player", 1, 100, new Inventory());
    }

    public void startGame(){
        while(true){
            IO.println(map.getCurrentRoom()); // questo fa automaticamente toString
            IO.println("Inserisci 'i' per consultare i comandi");
            String command = IO.readln("->");
            switch(command.toLowerCase()) {
                case "i":
                    showCommands();
                    break;
                case "w":
                    map.moveTo(player, Direction.NORTH);
                    break;
                case "d":
                    map.moveTo(player, Direction.EAST);
                    break;
                case "a":
                    map.moveTo(player, Direction.WEST);
                    break;
                case "s":
                    map.moveTo(player, Direction.SOUTH);
                    break;
                case "x":
                    map.getCurrentRoom().interact(player);
                    break;
                case "z":
                    boolean isEmpty = !player.showItems();
                    if(isEmpty){
                        System.out.println("Inventario vuoto...");
                        break;
                    }
                    int input = Integer.parseInt(IO.readln("Quale oggetto usare? ->"));
                    player.useItem(input);
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



    private static void showCommands(){
        System.out.print("""
                Inserisci:
                - 'w' per andare a Nord
                - 's' per andare a Sud
                - 'a' per andare a Ovest
                - 'd' per andare a Est
                - 'z' per aprire l'inventario
                - 'x' per interagire con la stanza
                """);
    }

    public void main(){
        World w = new World();
        w.startGame();
    }
}