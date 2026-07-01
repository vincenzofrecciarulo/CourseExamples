package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.entities.Merchant;
import org.generation.italy.examples.oo.mud.entities.Player;
import org.generation.italy.examples.oo.mud.entities.enemies.Enemy;
import org.generation.italy.examples.oo.mud.entities.enemies.Goblin;
import org.generation.italy.examples.oo.mud.entities.enemies.Ghost;
import org.generation.italy.examples.oo.mud.entities.enemies.Dragon;
import org.generation.italy.examples.oo.mud.items.Item;
import org.generation.italy.examples.oo.mud.items.Weapon;
import org.generation.italy.examples.oo.mud.items.Armor;
import org.generation.italy.examples.oo.mud.items.Shield;
import org.generation.italy.examples.oo.mud.items.Potion;

public class Main {
    public static boolean running;
    public static void main(String[] args) throws InterruptedException {
        // ---  GENERAZIONE DELLE STANZE ---
        Room atrio = new Room("Atrio del Castello", "Un grande ingresso polveroso. Ragnatele pendono dal soffitto.");
        Room armeria = new Room("Armeria Abbandonata", "Rastrelliere vuote e polvere di ferro coprono il pavimento.");
        Room giardino = new Room("Giardino Segreto", "La luce del sole illumina una fontana di marmo ormai secca.");
        Room cripta = new Room("Cripta Sotterranea", "L'aria è gelida. Lapidi spezzate circondano un altare dissacrato.");
        Room laboratorio = new Room("Laboratorio Alchemico", "Scaffali pieni di ampolle rotte. Si avverte un acre odore di zolfo.");
        Room torre = new Room("Torre dell'Orologio", "Ingranaggi massicci e cigolanti dominano lo spazio. C'è molto vento.");
        Room tesoro = new Room("Sala del Tesoro", "Una stanza blindata. Un enorme piedistallo svetta al centro.");
        Room mercato = new Room("Mercato del Villaggio", "Una piazza un tempo vivace, ora devastata dai saccheggiatori.");

        // --- COLLEGAMENTO DELLE STANZE ---
        // L'atrio è il centro di partenza a croce
        atrio.setExit(armeria, "e");
        atrio.setExit(giardino, "w");
        atrio.setExit(cripta, "s");
        atrio.setExit(mercato, "n");

        // Sviluppo del ramo Est (Armeria -> Laboratorio -> Tesoro)
        armeria.setExit(laboratorio, "n");
        laboratorio.setExit(tesoro, "n");

        // Sviluppo del ramo Ovest (Giardino -> Torre)
        giardino.setExit(torre, "n");

        // ---  POSIZIONAMENTO OGGETTI INIZIALI ---
        // Utilizziamo le sottoclassi polimorfiche corrette per sbloccare equipaggiamento e cure
        armeria.addItem(new Weapon("Spada_Antica", 6, 50.0, false));
        armeria.addItem(new Shield("Scudo_Rovinato", 12, 30.0, false));
        giardino.addItem(new Potion("Elisir_di_Vita", 25, 15.0));
        laboratorio.addItem(new Potion("Gran_Pozione", 60, 45.0));
        laboratorio.addItem(new Armor("Veste_di_Cuoio", 4, 80.0, false));
        cripta.addItem(new Weapon("Daga_Maledetta", 12, 110.0, true));
        torre.addItem(new Armor("Piastre_d_Acciaio", 9, 220.0, false));
        tesoro.addItem(new Item("Corona_Dorata", 1000.0, 2.0)); // Un tesoro prezioso generico non equipaggiabile



        // ---  CREAZIONE DEL GIOCATORE ---
        String playerName = IO.readln("Benvenuto nel MUD! Inserisci il nome del tuo eroe: ");
        Player player = new Player(playerName, atrio);

        // ---  IMPOSTIAMO LA DIFFICOLTA' ---
        String difficulty = Utils.choice("Scegli la difficolta' globale dei mostri \n" +
                "|[EASY]|[MEDIUM]|[HARD]\nScelta: ", "easy", "medium", "hard");
        running = true;
        IO.println("\nIl viaggio ha inizio...");

        // ---  POPOLAMENTO DEI MOSTRI NELLE RISPETTIVE STANZE ---
        Entity ladroMercato =new Goblin(difficulty, mercato, 3);
        mercato.populate(ladroMercato);
        Entity goblinEsploratore = new Goblin(difficulty, armeria, 1);
        armeria.populate(goblinEsploratore);
        Entity spettroInquieto = new Ghost(difficulty, cripta, 2);
        cripta.populate(spettroInquieto);
        Entity goblinSciamano = new Goblin(difficulty, laboratorio, 3);
        laboratorio.populate(goblinSciamano);
        Entity guardianoDellaTorre = new Ghost(difficulty, torre, 4);
        torre.populate(guardianoDellaTorre);
        Entity dragoAntico = new Dragon(difficulty, tesoro, 5);
        tesoro.populate(dragoAntico);
        Item premio = new Weapon("Ammazzadraghi", 18, 500.0, false);
        Entity mercante = new Merchant("Alis il Mercante", mercato, premio);
        mercato.populate(mercante);
        Room currentRoom = player.getCurrentRoom();
        IO.println("\n========================================");
        IO.println("TI TROVI IN: " + player.getCurrentRoom().getName());
        IO.println(currentRoom.getDescription());
        IO.println("========================================");
        while (running) {
            // --- CICLO DI GIOCO PRINCIPALE ---
            currentRoom = player.getCurrentRoom();
            String command = Utils.choice(
                    "Cosa vuoi fare?\n[N/S/E/W] per Muoverti | [I] per Inventario | "
                            + "[L] per Guardarti intorno | [A] per Attaccare | [T] per Parlare |" +
                            " [Q] per Uscire |\nScelta: ",
                    "n", "s", "e", "w", "i", "q", "l", "a", "t"
            );


            switch (command) {
                case "n":
                case "s":
                case "e":
                case "w":
                    boolean moved = player.moveTo(command);
                    if (moved) {
                        currentRoom = player.getCurrentRoom();
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
                    String inventoryReport = player.showInventory();
                    Thread.sleep(500);
                    IO.println(inventoryReport);
                    break;
                case "t":
                    boolean npcPresent = false;
                    for (Entity e : currentRoom.getPopulation()) {
                        if (!e.isHostile()) {
                            Merchant m = (Merchant) e;
                            IO.println(m.interact(player));
                            npcPresent = true;
                            break;
                        }
                    }
                    if (!npcPresent) {
                        IO.println("In questa stanza non c'è nessuno disposto a parlare con te.");
                    }
                    break;
                case "l":
                    IO.println(currentRoom.showItems());
                    String creatureReport = currentRoom.showPopulation();
                    if (!creatureReport.isEmpty()) {
                        IO.println(creatureReport);
                    }
                    if (currentRoom.hasItems()){
                        command = Utils.choice("Per raccogliere un oggetto [P] | Per continuare [C]", "p", "c");
                        if(command.equalsIgnoreCase("p")){
                            Item[] floorItems = currentRoom.getRoomItems();
                            String[] floorItemsNames = new String[currentRoom.getRoomItems().length];
                            for (int i = 0; i < floorItems.length; i++){
                                floorItemsNames[i] = floorItems[i].getName();
                            }
                            IO.println(player.pickUpItem(Utils.choice("Quale oggetto vuoi raccogliere?", floorItemsNames)));
                        }
                    }
                    break;
                case "a":
                    if(currentRoom.isEmpty()){
                        IO.println("CON LA TUA ARMA LANCI UN FENDENTE....");
                        Thread.sleep(1000);
                        IO.println("NON COLPISCI NULLA");
                    }
                    else{
                        boolean enemyPresent = false;
                        Enemy mob = null;
                        for(Entity e: currentRoom.getPopulation()){
                            if(e.isHostile()){
                                mob = (Enemy) e;
                                enemyPresent = true;
                            }
                        }
                        if(enemyPresent){
                            Utils.startCombat(player, mob);
                            if(mob.getCurrentRoom() == null) currentRoom.kickOut(mob);
                        }
                    }
                    break;

                case "q":
                    IO.println("Grazie per aver giocato! Alla prossima avventura.");
                    running = false;
                    break;
            }
        }
    }
}
