package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Player;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // --- FASE 1: GENERAZIONE DELLE STANZE ---
        Room atrio = new Room("Atrio del Castello", "Un grande ingresso polveroso. Ragnatele pendono dal soffitto.");
        Room armeria = new Room("Armeria Abbandonata", "Rastrelliere vuote e polvere di ferro coprono il pavimento.");
        Room giardino = new Room("Giardino Segreto", "La luce del sole illumina una fontana di marmo ormai secca.");
        Room tesoro = new Room("Sala del Tesoro", "Una stanza blindata. Un enorme piedistallo svetta al centro.");

        // --- FASE 2: COLLEGAMENTO DELLE STANZE ---
        // L'atrio è il centro: a Nord c'è il tesoro, a Est l'armeria, a Ovest il giardino
        atrio.setExit(tesoro, "n");
        atrio.setExit(armeria, "e");
        atrio.setExit(giardino, "w");

        // --- FASE 3: POSIZIONAMENTO OGGETTI INIZIALI ---
        armeria.addItem(new Item("Spada", 50, 4.5));
        giardino.addItem(new Item("Pozione", 20, 0.5));
        tesoro.addItem(new Item("Corona", 1000, 2.0));


        // --- FASE 4: CREAZIONE DEL GIOCATORE ---
        String playerName = IO.readln("Benvenuto nel MUD! Inserisci il nome del tuo eroe: ");
        Player player = new Player(playerName,atrio);
        // --- FASE 5: IMPOSTIAMO LA DIFFICOLTA' ---
        String difficulty=Utils.choice("Scegli la difficolta' \n" +
                "|[EASY]|[MEDIUM]|[HARD]","easy","medium","hard");
        boolean running = true;
        IO.println("\nIl viaggio ha inizio...");
        Room currentRoom=player.getCurrentRoom() ;
        //  Mostriamo dove si trova il giocatore
        IO.println("\n========================================");
        IO.println("TI TROVI IN: " + player.getCurrentRoom().getName());
        IO.println(currentRoom.getDescription());
        IO.println("========================================");
        while (running) {
            // --- FASE 6: CICLO DI GIOCO PRINCIPALE ---
            currentRoom = player.getCurrentRoom();
            //  Chiediamo l'azione usando la Utils.choice
            String command = Utils.choice(
                    "Cosa vuoi fare?\n[N/S/E/W] per Muoverti | [I] per Inventario | [Q] per Uscire | [L] per Guardarti intorno \nScelta: ",
                    "n", "s", "e", "w", "i", "q","l"
            );

            //  Gestiamo l'azione scelta
            switch (command) {
                case "n":
                case "s":
                case "e":
                case "w":
                    boolean moved = player.moveTo(command);
                    if (moved) {
                        currentRoom=player.getCurrentRoom();
                        IO.println("Ti sposti verso la nuova stanza...");
                        Thread.sleep(500);
                        IO.println("\n========================================");
                        IO.println("TI TROVI IN: " + currentRoom.getName());
                        IO.println(currentRoom.getDescription());
                        IO.println("========================================");
                    } else {
                        IO.println("C'è un muro in quella direzione! Non puoi passare.");
                        Thread.sleep(500);
                    }
                    break;

                case "i":
                    // Mostriamo l'inventario (che gestisce già al suo interno le scelte d/e/l)
                    String inventoryReport = player.showInventory();
                    Thread.sleep(500);
                    IO.println(inventoryReport);
                    break;

                case "q":
                    IO.println("Grazie per aver giocato! Alla prossima avventura.");
                    running = false;
                    break;
                case"l":
                    IO.println(currentRoom.showItems());
                    if (currentRoom.hasItems()){
                        command=Utils.choice("Per raccogliere un oggetto [P] | Per continuare [C]");
                        if(command.equalsIgnoreCase("p")){
                            Item[] floorItems= currentRoom.getRoomItems();
                            String[] floorItemsNames= new String[currentRoom.getRoomItems().length];
                            for (int i=0;i<floorItems.length;i++){
                                floorItemsNames[i]=floorItems[i].getName();
                            }
                            IO.println(player.pickUpItem(Utils.choice("Quale oggetto vuoi raccogliere?",floorItemsNames)));
                        }
                    }
            }
        }
    }
}
