package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
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
        player = new Player(50,"Jacopo",1,start);
    }

    public void startGame(){
        while(true){
            IO.println(player.getCurrentRoom()); // questo fa automaticamente toString della Room
            IO.println("1: muoverti");
            IO.println("2: raccogliere oggetti");
            IO.println("3: entra nel menù");
            IO.println("4: combattere");
            IO.println("5: esci dal gioco");
            String command = IO.readln("Cosa vuoi fare?");
            int userInput = Integer.parseInt(command);
            switch(userInput) {
                case 1:
                        playerMove();
                    break;
                case 2:
                        managePlayerPick();
                    break;
                case 3:
                        managePlayerMenu();
                    break;
                case 4:
                        IO.println("Non abbiamo ancora un sistema di combattimento :(");
                    break;
                case 5:
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito che cosa vuoi!");
            }
        }
    }
    // creare un metodo che gestisce l'intero inventario, il giocatore puo accedere come sotto menu
    // puo scegliere diverse opzioni, vedere il proprio inventario, stampare le proprie statistiche, fare un drop di
    // un oggetto.
    public void managePlayerMenu(){
        while (true){
            IO.println("Benvenuto nel menù");
            IO.println("1: Vedi le tue statistiche");
            IO.println("2: Vedi il tuo inventario");
            IO.println("3: Esci");
            String userInput = IO.readln("-> ");
            int choice = Integer.parseInt(userInput);
            switch (choice){
                case 1:
                    IO.println(player.toString());
                    break;
                case 2:
                    managePlayerInventory();
                    break;
                case 3:
                    IO.println("Ritorno al mondo di gioco");
                    return;
                default:
                    IO.println("Non ho capito!");
                    break;
            }

        }
    }

    public void managePlayerInventory(){
        // stampare l'inventario, l'utente puo selezionare un oggetto,
        // selezionato facciamo leggere l'item e se vuole buttarlo altrimenti ritorna nell'inventario
        while(!player.getInventory().isEmpty()) {
            player.inventoryToString();
            IO.println("Scegli l'item su cui vuoi sapere di più");
            IO.println("Premi 0 per tornare indietro");
            String item = IO.readln("-> ");
            int indexItem = Integer.parseInt(item);
            if (indexItem == 0) return;
            IO.println(player.showItem(indexItem));
            IO.println("1: Drop");
            IO.println("2: Indietro");
            String command = IO.readln("-> ");
            int intCommand = Integer.parseInt(command);
            switch (intCommand) {
                    case 1:
                        managePlayerDrop(indexItem);
                        break;
                    case 2:
                        break;
                    default:
                        IO.println("Non ho capito cosa vuoi fare!");
                }
        }
        IO.println("Inventario Vuoto!");
    }

    private void managePlayerDrop(int indexItem) {
            boolean hasSuccess = player.tryDropItem(indexItem);
            if (hasSuccess){
                Item item = player.dropItem(indexItem);
                IO.println(item.getName() + " droppato con successo");
                Room currRoom = player.getCurrentRoom();
                currRoom.addItem(item);
            } else {
                IO.println("Qualcosa è andato storto");
            }
    }

    public void managePlayerPick(){
        Room currentRoom = player.getCurrentRoom();
        boolean isRoomEmpty = currentRoom.getObjectNames().isEmpty();
        if (isRoomEmpty){
            IO.println("Nessun oggetto nella stanza");
            return;
        }
        IO.println("Scegli l'oggetto da prendere ->");
        currentRoom.itemsToString();
        int input = Integer.parseInt(IO.readln("scrivi l'indice del oggetto che vuoi aggiungere"));
        IO.println(player.pick(input));
    }

    public void playerMove(){
        while(true){
            String command = IO.readln("Dove vuoi andare ->");
            boolean success = false;
            switch(command.toLowerCase()) {
                case "n":
                    success = player.moveTo(Room.NORTH);
                    break;
                case "e":
                    success = player.moveTo(Room.EAST);
                    break;
                case "w":
                    success = player.moveTo(Room.WEST);
                    break;
                case "s":
                    success = player.moveTo(Room.SOUTH);
                    break;
                case "q":
                    IO.println("Non ti muovi");
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

    public void main(){
        World w = new World();
        w.startGame();
    }
}