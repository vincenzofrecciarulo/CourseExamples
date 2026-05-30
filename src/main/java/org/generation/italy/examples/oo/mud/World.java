package org.generation.italy.examples.oo.mud;

import com.generation.library.*;
import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;

    public World() {

        // ── STANZA 1: Piazza del Mercato (spawn) ──────────────────────────────
        ArrayList<Entity> es1 = new ArrayList<>();
        es1.add(new Entity(50, "Ciro la Guardia", 7));

        ArrayList<Item> os1 = new ArrayList<>();
        os1.add(new Item(2, 10, "Bastone di Legno"));
        os1.add(new Item(3, 9, "Scudo di Ferro"));

        Room mercato = new Room("Piazza del Mercato",
                "Ti trovi nella Piazza del Mercato, piena di artigiani e fannulloni.\n" +
                        "L'aria odora di spezie e letame. Un guardiano ti osserva storto.", es1, os1);

        // ── STANZA 2: Tempio del Sole ─────────────────────────────────────────
        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(1, 20, "Pozione di Cura"));
        os2.add(new Item(1, 15, "Benda Sacra"));

        Room tempio = new Room("Tempio del Sole",
                "Colonne di marmo bianco si innalzano verso la volta stellata.\n" +
                        "Monaci in veste dorata pregano in silenzio.", new ArrayList<>(), os2);

        // ── STANZA 3: Foresta Oscura ──────────────────────────────────────────
        ArrayList<Entity> es3 = new ArrayList<>();
        es3.add(Monster.goblin());
        es3.add(Monster.ragno());

        ArrayList<Item> os3 = new ArrayList<>();
        os3.add(new Item(0.5, 5, "Fungo Velenoso"));
        os3.add(new Item(1, 12, "Ramo Appuntito"));

        Room foresta = new Room("Foresta Oscura",
                "Gli alberi si stringono intorno a te soffocando la luce.\n" +
                        "Si sentono fruscii inquietanti tra le frasche.", es3, os3);

        // ── STANZA 4: Rovine del Castello ─────────────────────────────────────
        ArrayList<Entity> es4 = new ArrayList<>();
        es4.add(Monster.scheletro());
        es4.add(Monster.scheletro());

        ArrayList<Item> os4 = new ArrayList<>();
        os4.add(new Item(8, 50, "Spada Arrugginita"));
        os4.add(new Armor(6, 40, "Corazza Spezzata", false));

        Room rovine = new Room("Rovine del Castello",
                "Muri crollati e torri mozzate ricordano la grandezza perduta.\n" +
                        "Il silenzio è rotto solo dal crepitio di ossa.", es4, os4);

        // ── STANZA 5: Taverna del Cinghiale Ubriaco ───────────────────────────
        ArrayList<Entity> es5 = new ArrayList<>();
        es5.add(new Entity(80, "Bardo Malvino", 4));
        es5.add(new Entity(60, "Taberniere Grasso", 2));

        ArrayList<Item> os5 = new ArrayList<>();
        os5.add(new Item(1, 8, "Boccale di Birra"));
        os5.add(new Item(0.5, 25, "Mappa Sgualcita"));

        Room taverna = new Room("Taverna del Cinghiale Ubriaco",
                "Calore, rumore e fumo di pipa ti avvolgono all'ingresso.\n" +
                        "Un bardo intona una ballata scurrile tra le risate degli avventori.", es5, os5);

        // ── STANZA 6: Miniera Abbandonata ─────────────────────────────────────
        ArrayList<Entity> es6 = new ArrayList<>();
        es6.add(Monster.orco());

        ArrayList<Item> os6 = new ArrayList<>();
        os6.add(new Item(5, 80, "Pepita d'Oro"));
        os6.add(new Item(3, 60, "Piccone Incantato"));

        Room miniera = new Room("Miniera Abbandonata",
                "Gallerie buie si diramano in ogni direzione.\n" +
                        "Il rumore di qualcosa di enorme echeggia nelle profondità.", es6, os6);

        // ── STANZA 7: Torre del Mago ──────────────────────────────────────────
        ArrayList<Entity> es7 = new ArrayList<>();
        es7.add(new Entity(120, "Archimago Vetharion", 12));

        ArrayList<Item> os7 = new ArrayList<>();
        os7.add(new Item(0.5, 200, "Libro degli Incantesimi"));
        os7.add(new Item(1, 150, "Amuleto del Fulmine"));

        Room torre = new Room("Torre del Mago",
                "Scaffali pieni di libri polverosi coprono ogni parete.\n" +
                        "Un vecchio mago ti fissa attraverso lenti a pince-nez.", es7, os7);

        // ── STANZA 8: Cripta dei Re ───────────────────────────────────────────
        ArrayList<Entity> es8 = new ArrayList<>();
        es8.add(Monster.vampiro());

        ArrayList<Item> os8 = new ArrayList<>();
        os8.add(new Armor(10, 300, "Armatura Reale", false));
        os8.add(new Item(2, 250, "Corona d'Argento"));

        Room cripta = new Room("Cripta dei Re",
                "Sarcofagi di pietra allineati lungo le pareti.\n" +
                        "L'aria è gelida e una presenza oscura aleggia nell'ombra.", es8, os8);

        // ── STANZA 9: Tana del Drago (boss) ───────────────────────────────────
        ArrayList<Entity> es9 = new ArrayList<>();
        es9.add(Monster.drago());

        ArrayList<Item> os9 = new ArrayList<>();
        os9.add(new Item(1, 1000, "Uovo di Drago"));
        os9.add(new Armor(15, 800, "Scaglia di Drago", false));

        Room tana = new Room("Tana del Drago",
                "Un calore soffocante emana dalle pareti di roccia fusa.\n" +
                        "Montagne di tesori brillano ai lati. Al centro... qualcosa si muove.", es9, os9);

        // ── CONNESSIONI ────────────────────────────────────────────────────────
        //
        //          [Torre]
        //             |N
        //  [Taverna]-W[Mercato]-E-[Foresta]
        //             |S               |S
        //          [Tempio]        [Rovine]
        //             |S               |S
        //          [Miniera]       [Cripta]
        //                              |S
        //                           [Tana]

        mercato.addExit(tempio,   Room.SOUTH);
        mercato.addExit(foresta,  Room.EAST);
        mercato.addExit(taverna,  Room.WEST);
        mercato.addExit(torre,    Room.NORTH);

        tempio.addExit(mercato,   Room.NORTH);
        tempio.addExit(miniera,   Room.SOUTH);

        foresta.addExit(mercato,  Room.WEST);
        foresta.addExit(rovine,   Room.SOUTH);

        rovine.addExit(foresta,   Room.NORTH);
        rovine.addExit(cripta,    Room.SOUTH);

        taverna.addExit(mercato,  Room.EAST);

        torre.addExit(mercato,    Room.SOUTH);

        miniera.addExit(tempio,   Room.NORTH);

        cripta.addExit(rovine,    Room.NORTH);
        cripta.addExit(tana,      Room.SOUTH);

        tana.addExit(cripta,      Room.NORTH);

        start = mercato;
    }

    public void startGame() {
        current = start;
        Player p1 = new Player(100, "Eroe", 1, current);
        boolean newRoom = true;

        while (true) {
            if (newRoom) {
                IO.println("\n══════════════════════════════════════");
                IO.println(current.toString());
                newRoom = false;
            }

            IO.println("\nCosa vuoi fare?");
            IO.println("  I - Inventario    M - Muoviti");
            IO.println("  E - Esplora       P - Raccogli oggetto");
            IO.println("  Q - Esci");

            String choice = IO.readln("-> ");

            switch (choice.toLowerCase()) {
                case "i":
                    p1.openInventory();
                    break;

                case "m":
                    IO.println("Direzione? (N / E / S / W)");
                    String dir = IO.readln("-> ");
                    boolean success = false;
                    switch (dir.toLowerCase()) {
                        case "n": success = moveTo(Room.NORTH); break;
                        case "e": success = moveTo(Room.EAST);  break;
                        case "s": success = moveTo(Room.SOUTH); break;
                        case "w": success = moveTo(Room.WEST);  break;
                        default:  IO.println("Direzione non riconosciuta."); continue;
                    }
                    if (success) {
                        p1.setCurrentRoom(current);
                        newRoom = true;
                        checkMonsters(current);
                    } else {
                        IO.println("Non c'è nulla in quella direzione.");
                    }
                    break;

                case "e":
                    IO.println(current.infoRoom());
                    break;

                case "p":
                    pickItemMenu(p1);
                    break;

                case "q":
                    IO.println("Grazie per aver giocato. A presto, avventuriero!");
                    return;

                default:
                    IO.println("Comando non riconosciuto.");
            }
        }
    }

    // Avvisa il giocatore se ci sono mostri nella stanza
    private void checkMonsters(Room room) {
        ArrayList<String> nomiEntita = room.getEntityNames();
        if (!nomiEntita.isEmpty()) {
            IO.println("⚠ Attenzione: nella stanza sono presenti " + nomiEntita + "!");
        }
    }

    // Menu selezione oggetto da raccogliere
    private void pickItemMenu(Player player) {
        ArrayList<Item> items = current.getItems();
        if (items.isEmpty()) {
            IO.println("Non ci sono oggetti da raccogliere qui.");
            return;
        }
        IO.println("Oggetti presenti:");
        for (int i = 0; i < items.size(); i++) {
            IO.println("  " + i + ". " + items.get(i).getName());
        }
        IO.println("Inserisci il numero dell'oggetto (o -1 per annullare):");
        int idx = Console.readInt();
        if (idx < 0 || idx >= items.size()) {
            IO.println("Scelta annullata.");
            return;
        }
        String nomeOggetto = items.get(idx).getName();
        boolean picked = player.pickItem(items.get(idx));
        if (picked) {
            IO.println("Hai raccolto: " + nomeOggetto);
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

    public static void main(String[] args) {
        World w = new World();
        w.startGame();
    }
}