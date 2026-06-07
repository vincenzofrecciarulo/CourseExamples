package org.generation.italy.examplesMio.ooMio.mudMio.coreMio;

import org.generation.italy.examplesMio.ooMio.mudMio.battleMio.Combat;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.Player;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies.Goblin;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies.Merchant;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies.Monster;
import org.generation.italy.examplesMio.ooMio.mudMio.charactersMio.enemies.Orc;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Item;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Potion;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Weapon;
import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Race;
import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Warrior;
import org.generation.italy.examplesMio.ooMio.mudMio.rpgMio.Wizard;

import java.util.ArrayList;

import java.util.List;

public class World {
    private Room start;
    private Room current;
    private Player player;


    public World() {

        player = new Player("Eroe", Race.HUMAN, "male", new Warrior(), null, 10);

        ArrayList<Item> merchantItems = new ArrayList<>(List.of(
                new Item(2.0, 50, "Libro di Magia"),
                new Weapon(3.0, 5, "Bastone di Legno", 4),
                new Weapon(4.0, 8, "Spada Arrugginita", 8),
                new Item(6.0, 20, "Scudo"),
                new Weapon(2.0, 25, "Arco Corto", 6),
                new Item(0.1, 1, "Freccia"),
                new Weapon(1.0, 10, "Pugnale", 5),
                new Weapon(5.0, 35, "Ascia da Guerra", 12),
                new Potion(0.5, 30, "Pozione Curativa", 20),
                new Potion(0.5, 35, "Pozione di Mana", 15),
                new Item(0.1, 40, "Anello d'Argento"),
                new Item(1.0, 2, "Torcia"),
                new Item(3.0, 5, "Corda"),
                new Item(2.0, 15, "Elmo di Ferro"),
                new Item(8.0, 40, "Armatura di Cuoio"),
                new Item(20.0, 100, "Armatura di Ferro"),
                new Item(0.2, 150, "Gemma Preziosa"),
                new Item(0.1, 25, "Pergamena Magica"),
                new Item(1.0, 12, "Mantello del Viandante"),
                new Item(0.1, 50, "Chiave Misteriosa")
        ));


        ArrayList<Merchant> merchantEntities = new ArrayList<>();
        merchantEntities.add(new Merchant(30, "Annorax il mercante", 4, Race.HUMAN, "Male", new Wizard(), null, merchantItems));

        ArrayList<Item> os = new ArrayList<>();
        os.add(new Weapon(2.0, 10, "Bastone di legno", 4));
        os.add(new Item(3, 9, "Scudo di ferro"));


        ArrayList<Monster> orcMonsters = new ArrayList<>();
        orcMonsters.add(new Orc("Grog", "male"));

        ArrayList<Monster> goblinMonsters = new ArrayList<>();
        goblinMonsters.add(new Goblin("Huzema", "Male"));

        Room ms = new Room("Piazza del Mercato", """
                Ti trovi nella Piazza del Mercato piena di artigiani e fannulloni!
                """, new ArrayList<>(), os, new ArrayList<>(), merchantEntities);

        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(4, 8, "Ago di metallo"));

        // stanza del tempio
        Room ts = new Room("Piazza del Tempio", """
                Qui vengono a curarsi gli avventurieri malati!
                """, new ArrayList<>(), os2, orcMonsters, new ArrayList<>());

        ms.addExit(ts, Room.NORTH);
        ts.addExit(ms, Room.SOUTH);
        start = ms;
    }

    public void startGame() {
        current = start;
        boolean firstTime = true;



        while (true) {
            if (firstTime) {
                IO.println("\n===================\n");
                IO.println("Comandi disponibili: ");
                IO.println("n/s/e/w - Muoviti");
                IO.println("t - Parla con i mercanti");
                IO.println("p - Raccogli oggetti");
                IO.println("i - Inventario");
                IO.println("q - Esci");
                IO.println("\n===================\n");
                firstTime = false;
            }
            // IO.println(current.getTitle());
            // IO.println(current.getDescription());
            IO.println(current); // questo fa automaticamente toString
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
                case "t":

                    if (!current.getMerchants().isEmpty()) {
                        Merchant merchant = current.getMerchants().get(0);
                        IO.println("Benvenuto da " + merchant.getName() + "!");
                        ArrayList<String> items = merchant.showItems();
                        for (int i = 0; i < items.size(); i++) {
                            IO.println(i + ". " + items.get(i));
                        }
                        IO.println("X. Esci dal negozio");
                        String choice = IO.readln("Scegli un item (numero): ");
                        if (choice.equalsIgnoreCase("X")) {
                            IO.println("Arrivederci!");
                        } else {
                            int index = Integer.parseInt(choice) - 1;
                            Item item = merchant.getItemsToSell().get(index);
                            merchant.sellItems(item, player);
                        }
                    }
                    continue;
                case "p":
                    if (!current.getItems().isEmpty()) {
                        ArrayList<String> itemNames = current.getObjectNames();
                        for (int i = 0; i < itemNames.size(); i++) {
                            IO.println(i + ". " + itemNames.get(i));
                        }
                        String choice = IO.readln("Quale oggetto vuoi prendere?");
                        int index = Integer.parseInt(choice);
                        Item item = current.getItems().get(index);
                        player.getInventory().addItem(item);
                        current.removeItemFromRoom(item);
                        IO.println("Hai raccolto " + item.getName());
                        if (item instanceof Weapon) {
                            String equip = IO.readln("Vuoi equipaggiare " + item.getName() + "? (S / N)");
                            if (equip.equalsIgnoreCase("s")) {
                                player.setEquippedWeapon((Weapon) item); // ((Weapon) item) --> cast - serve per dire a Java di trattare Item come una Weapon
                                IO.println("Hai equipaggiato " + item.getName());
                            }
                        }
                    } else {
                        IO.println("Non ci sono oggetti qui!");
                    }
                    continue;
                case "i":
                    if(player.getInventory().getItems().isEmpty()){
                        IO.println("Il tuo inventario è vuoto");
                    }else {
                        for (Item item : player.getInventory().getItems()) {
                            IO.println(item.getName());
                        }
                        String use = IO.readln("Vuoi usare un oggetto?");
                        if (!use.equalsIgnoreCase("x")) {
                            int index = Integer.parseInt(use);
                            Item item = player.getInventory().getItems().get(index);
                            if (item instanceof Potion) {
                                IO.println("Hai usato " + item.getName() + " e recuperato " + ((Potion) item).getHealAmount() + " HP!");
                                player.healAmount(((Potion) item).getHealAmount());
                            }
                            player.getInventory().removeItem(item);
                        }
                        IO.println("Peso attuale: " + player.getInventory().getCurrentWeight() + " / " + player.getInventory().getMaxWeight());
                        IO.println("Monete: " + player.getCoins());
                    }
                    continue;
                case "?":
                    IO.println("Comandi disponibili:");
                    IO.println("n/s/e/w - Muoviti");
                    IO.println("t - Parla con i mercanti");
                    IO.println("p - Raccogli oggetti");
                    IO.println("i - Inventario");
                    IO.println("? - Help");
                    IO.println("q - Esci");
                    IO.println("\n===================\n");
                    continue;
                case "q":
                    IO.println("Grazie per aver giocato");
                    return;
                default:
                    IO.println("Non ho capito che cosa vuoi!");
                    continue;
            }

            if (success) {
                IO.println("Te ne vai a " + command);
                if (!current.getMonsters().isEmpty()) {
                    Monster monster = current.getMonsters().get(0);
                    Combat combat = new Combat(player, monster);
                    boolean alive = combat.startCombat();
                    if (!alive) {
                        return;
                    }
                }
            } else {
                IO.println("Non c'è nulla in quella direzione");
            }
        }
    }

    private boolean moveTo(int direction) {
        Room destination = current.exitAt(direction);
        if (destination != null) {
            current = destination;
            return true;
        }
        return false;
    }


}