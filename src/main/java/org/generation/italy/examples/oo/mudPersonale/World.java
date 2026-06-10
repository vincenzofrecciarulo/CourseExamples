package org.generation.italy.examples.oo.mudPersonale;

import org.generation.italy.examples.oo.mudPersonale.entities.Player;
import org.generation.italy.examples.oo.mudPersonale.enums.Direction;
import org.generation.italy.examples.oo.mudPersonale.items.Item;


public class World {
    public static final Map map = new Map();
    private final Player player;

    public World(){
        //es.add(new Entity(50, "Ciro la Guardia", 7));
        //os.add(new Item(2, 10, "Bastone di legno"));
        //os.add(new Item(3, 9, "Scudo di ferro"));
        //os2.add(new Item(4, 8, "Ago di metallo"));
        // stanza del tempio
        player = new Player("Player", 100, new Inventory());
    }

    public void startGame() throws Exception {
        while(true){
            IO.println(player.getCurrentRoom(map)); // questo fa automaticamente toString
            IO.println("Inserisci 'i' per consultare i comandi");
            String command = IO.readln("->");
            switch(command.toLowerCase()) {
                case "i":
                    showCommands();
                    break;
                case "w":
                    player.moveTo(map, Direction.NORTH);
                    break;
                case "d":
                    player.moveTo(map, Direction.EAST);
                    break;
                case "a":
                    player.moveTo(map, Direction.WEST);
                    break;
                case "s":
                    player.moveTo(map, Direction.SOUTH);
                    break;
                case "x":
                    player.getCurrentRoom(map).interact(player);
                    break;
                case "z":
                    boolean isEmpty = !player.showItems();
                    if(isEmpty){
                        System.out.println("Inventario vuoto...");
                        break;
                    }

                    try{
                        int input = Integer.parseInt(IO.readln("Seleziona un item ->"));
                        Item item = player.findItem(input);
                        if(item == null){
                            IO.println("Item non trovato");
                            break;
                        }
                        String useOrDrop = IO.readln("Usare (0) o buttare (1)? ");
                        if(useOrDrop.equals("0")){
                            item.interact(player);
                        }else if(useOrDrop.equals("1")){
                            player.drop(item);
                            IO.println("Hai buttato " + item.getName());
                        }
                    }catch (Exception e){
                        IO.println("Item non valido");
                    }
                    break;
                case "p":
                    player.showPokemon();
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
                - 'p' per controllare pokemon
                """);
    }

    void main() throws Exception {
        World w = new World();
        w.startGame();
    }
}