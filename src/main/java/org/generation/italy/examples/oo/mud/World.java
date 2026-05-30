package org.generation.italy.examples.oo.mud;

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
                new Item(3.0, 5, "Bastone di Legno"),
                new Item(4.0, 8, "Spada Arrugginita"),
                new Item(6.0, 20, "Scudo"),
                new Item(2.0, 25, "Arco Corto"),
                new Item(0.1, 1, "Freccia"),
                new Item(1.0, 10, "Pugnale"),
                new Item(5.0, 35, "Ascia da Guerra"),
                new Item(0.5, 30, "Pozione Curativa"),
                new Item(0.5, 35, "Pozione di Mana"),
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

        /*ArrayList<Item> os = new ArrayList<>();
        os.add(new Item(2, 10, "Bastone di legno"));
        os.add(new Item(3, 9, "Scudo di ferro"));*/


        ArrayList<Monster> orcMonsters = new ArrayList<>();
        orcMonsters.add(new Orc("Grog", "male"));

        ArrayList<Monster> goblinMonsters = new ArrayList<>();
        goblinMonsters.add(new Goblin("Huzema", "Male"));

        Room ms = new Room("Piazza del Mercato",
                """
                        Ti trovi nella Piazza del Mercato piena di artigiani e fannulloni!
                        """, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), merchantEntities
        );

        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(4, 8, "Ago di metallo"));

        // stanza del tempio
        Room ts = new Room("Piazza del Tempio",
                """
                        Qui vengono a curarsi gli avventurieri malati!
                        """, new ArrayList<>(), os2, orcMonsters, new ArrayList<>()
        );

        ms.addExit(ts, Room.NORTH);
        ts.addExit(ms, Room.SOUTH);
        start = ms;
    }

    public void startGame() {
        current = start;

        while (true) {
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
                    if(!current.getMerchants().isEmpty()){
                        Merchant merchant = current.getMerchants().get(0);
                        IO.println("Benvenuto da " + merchant.getName() + "!");
                        ArrayList<String> items = merchant.showItems();
                        for(int i = 0; i < items.size(); i++){
                            IO.println(i + ". " + items.get(i));
                        }
                        String choice = IO.readln("Scegli un item (numero): ");
                        int index = Integer.parseInt(choice);
                        Item item = merchant.getItemsToSell().get(index);
                        merchant.sellItems(item, player);
                    }
                    break;
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

    public void main() {
        World w = new World();
        w.startGame();
    }
}