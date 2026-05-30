package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;
    private Player player;
    private GameIO io;

    public World(){
        this(new ConsoleIO());
    }

    /**
     * Create a world using a provided GameIO (useful for tests)
     */
    public World(GameIO io){
         this.io = io;
         // Build a richer fantasy city map following a north-south vertical axis

         // NORTHMOST: Foresta Profonda (Deep Forest)
         Room df = new Room("Foresta Profonda",
                 """
                         Alberi secolari, il suono degli animali e un senso di mistero. Meglio non avventurarsi da soli.
                         """, new ArrayList<>(), new ArrayList<>());

         // Populate deep forest
         df.addEntity(new Entity(12, "Lupo Solitario", 2));
         df.getItems().add(new Item(0.1, 8, "Pelle di Lupo"));

         // Bordo della Foresta (Forest Edge) - south of Foresta Profonda
         Room fe = new Room("Bordo della Foresta",
                 """
                         Liane e alberi fitti segnano l'inizio della foresta. Sentieri tortuosi si inoltrano tra gli alberi.
                         """, new ArrayList<>(), new ArrayList<>());

         // Prato Fiorito (Meadow) - EAST of Bordo della Foresta
         Room md = new Room("Prato Fiorito",
                 """
                         Un ampio prato costellato di fiori selvatici, perfetto per accamparsi o riposarsi.
                         """, new ArrayList<>(), new ArrayList<>());

         // Torrione di Guardia (Watchtower) - south of Bordo della Foresta
         Room wt = new Room("Torrione di Guardia",
                 """
                         Un'alta torre con vedetta: dalla sommità si domina la città e le terre circostanti.
                         """, new ArrayList<>(), new ArrayList<>());

         // Armeria del Falco (Armory) - south of Torrione di Guardia
         ArrayList<Item> armItems = new ArrayList<>();
         armItems.add(new Item(5.0, 25, "Spada di Ferro"));
         armItems.add(new Item(6.0, 20, "Scudo"));
         Room am = new Room("Armeria del Falco",
                 """
                         Esposizione di armi e armature lucenti. Il proprietario affila le lame con cura.
                         """, new ArrayList<>(), armItems);

         am.addEntity(new Entity(35, "Mastro Armaiolo", 6));

         // Fucina Laterale (Side Smithy) - WEST of Armeria
         Room fucina = new Room("Fucina Laterale",
                 """
                         Una piccola fucina dove si riparano armi e armature. Il fuoco arde costante.
                         """, new ArrayList<>(), new ArrayList<>());

         // Piazza del Tempio (Temple Square) - south of Armeria
         ArrayList<Entity> templeEntities = new ArrayList<>();
         templeEntities.add(new Entity(30, "Sacerdote Anziano", 6));
         ArrayList<Item> templeItems = new ArrayList<>();
         templeItems.add(new Item(0.2, 15, "Amuleto della Dea"));
         Room ts = new Room("Piazza del Tempio",
                 """
                         Davanti al grande tempio, la piazza è calma. I devoti accendono candele.
                         Una scalinata maestosa conduce all'interno del santuario.
                         """, templeEntities, templeItems
         );

         // Biblioteca della Città (Library) - EAST of Piazza del Tempio
         ArrayList<Entity> libEntities = new ArrayList<>();
         libEntities.add(new Entity(20, "Vecchio Saggio", 8));
         ArrayList<Item> libItems = new ArrayList<>();
         libItems.add(new Item(0.1, 12, "Pergamena Antica"));
         Room lib = new Room("Biblioteca della Città",
                 """
                         Scaffali alti pieni di libri, volumi polverosi e tavolette di studio.
                         Chi cerca conoscenza spesso si ferma qui per ore.
                         """, libEntities, libItems);

         lib.addEntity(new Entity(18, "Apprendista Bibliotecario", 2));

         // Forno di Lieta (Bakery) - WEST of Piazza del Tempio
         ArrayList<Item> bakeryItems = new ArrayList<>();
         bakeryItems.add(new Item(0.4, 5, "Pagnotta Calda"));
         bakeryItems.add(new Item(0.2, 2, "Fetta di Pane"));
         Room bk = new Room("Forno di Lieta",
                 """
                         Una piccola bottega dove il pane sfornato attira clienti: il profumo è irresistibile.
                         """, new ArrayList<>(), bakeryItems);

         bk.addEntity(new Entity(22, "Fornaio", 3));

         // Piazza del Mercato (Market Square) - SOUTH of Piazza del Tempio (START)
         ArrayList<Entity> marketEntities = new ArrayList<>();
         marketEntities.add(new Entity(40, "Guardia del Mercato", 5));
         ArrayList<Item> marketItems = new ArrayList<>();
         marketItems.add(new Item(1.0, 2, "Mela"));
         marketItems.add(new Item(0.5, 1, "Moneta"));
         Room ms = new Room("Piazza del Mercato",
                 """
                         Sei nella vivace Piazza del Mercato: banchi, venditori e passanti rumorosi.
                         Le urla dei venditori ti circondano e l'aria profuma di spezie e pane.
                         """, marketEntities, marketItems
         );

         // Giardino della Città (Garden) - SOUTH of Piazza del Mercato
         Room gs = new Room("Giardino della Città",
                 """
                         Un giardino curato: panchine, siepi potate e una piccola fontana.
                         È il luogo preferito da chi cerca un attimo di pace.
                         """, new ArrayList<>(), new ArrayList<>());

         // Taverna del Pugnale Rosso (Tavern) - WEST of Piazza del Mercato
         ArrayList<Entity> tavEntities = new ArrayList<>();
         tavEntities.add(new Entity(25, "Oste Burlone", 3));
         ArrayList<Item> tavItems = new ArrayList<>();
         tavItems.add(new Item(0.3, 3, "Fiaschetta di vino"));
         Room tv = new Room("Taverna del Pugnale Rosso",
                 """
                         Odore di birra e carne al fuoco. Avventurieri e mercanti si scambiano voci di tesori.
                         Il bardo sta intonando una canzone al bancone.
                         """, tavEntities, tavItems);

         // Molo (Docks) - EAST of Piazza del Mercato
         ArrayList<Entity> dockEntities = new ArrayList<>();
         dockEntities.add(new Entity(20, "Capitano del Porto", 4));
         ArrayList<Item> dockItems = new ArrayList<>();
         dockItems.add(new Item(2.0, 5, "Corda"));
         Room dk = new Room("Molo",
                 """
                         Onde che lambiscono il legno e gabbiani in volo. Il molo è pieno di casse e reti.
                         Le imbarcazioni caricano e scaricano merci esotiche.
                         """, dockEntities, dockItems);

         // Riva del Fiume (Riverbank) - SOUTH of Molo
         Room rb = new Room("Riva del Fiume",
                 """
                         Lenta corrente del fiume; pescatori e bambini giocano sulle rive.
                         """, new ArrayList<>(), new ArrayList<>());

         // Ingresso della Caverna (Cave Entrance) - SOUTH of Riva del Fiume
         Room cave = new Room("Ingresso della Caverna",
                 """
                         Un'apertura scura nella roccia: rumori sommessi provengono dall'interno.
                         """, new ArrayList<>(), new ArrayList<>());

         cave.getItems().add(new Item(0.05, 1, "Vecchia Chiave"));

         // Tana del Goblin (Goblin Den) - SOUTH of Ingresso della Caverna
         Room gd = new Room("Tana del Goblin",
                 """
                         Una grotta sporca, piena di cumuli di ossa e torce annerite. Sembra pericolosa.
                         """, new ArrayList<>(), new ArrayList<>());

         gd.addEntity(new Entity(8, "Capo Goblin", 4));
         gd.getItems().add(new Item(0.0, 100, "Scrigno del Tesoro"));

         // === LINK ALL EXITS ===

         // North-South Main Axis
         df.addExit(fe, Room.SOUTH);
         fe.addExit(df, Room.NORTH);

         fe.addExit(wt, Room.SOUTH);
         wt.addExit(fe, Room.NORTH);

         wt.addExit(am, Room.SOUTH);
         am.addExit(wt, Room.NORTH);

         am.addExit(ts, Room.SOUTH);
         ts.addExit(am, Room.NORTH);

         ts.addExit(ms, Room.SOUTH);
         ms.addExit(ts, Room.NORTH);

         ms.addExit(gs, Room.SOUTH);
         gs.addExit(ms, Room.NORTH);

         // East-West connections
         fe.addExit(md, Room.EAST);
         md.addExit(fe, Room.WEST);

         am.addExit(fucina, Room.WEST);
         fucina.addExit(am, Room.EAST);

         ts.addExit(lib, Room.EAST);
         lib.addExit(ts, Room.WEST);

         ts.addExit(bk, Room.WEST);
         bk.addExit(ts, Room.EAST);

         ms.addExit(tv, Room.WEST);
         tv.addExit(ms, Room.EAST);

         ms.addExit(dk, Room.EAST);
         dk.addExit(ms, Room.WEST);

         // Docks continuation south
         dk.addExit(rb, Room.SOUTH);
         rb.addExit(dk, Room.NORTH);

         rb.addExit(cave, Room.SOUTH);
         cave.addExit(rb, Room.NORTH);

         cave.addExit(gd, Room.SOUTH);
         gd.addExit(cave, Room.NORTH);

         // Starting location
         start = ms;
     }

    public void startGame(){
         current = start;
         // create a default player and put into the start room
         player = new Player(30, "Dink Smallwood", 1);
         current.addEntity(player);

         while(true){
             io.println(current.toString());
             String line = io.readln("-> ");
             if(line==null) break;
             String command = line.trim();
             if(command.isEmpty()) continue;

             String[] parts = command.split("\\s+", 2);
             String verb = parts[0].toLowerCase();
             String arg = parts.length>1? parts[1].trim():"";

             boolean moved = false;
             switch(verb){
                 // Movement: Italian + English + shortcuts
                 case "n": case "nord": case "north":
                     moved = moveTo(Room.NORTH);
                     break;
                 case "e": case "est": case "east":
                     moved = moveTo(Room.EAST);
                     break;
                 case "o": case "ovest": case "west":
                     moved = moveTo(Room.WEST);
                     break;
                 case "s": case "sud": case "south":
                     moved = moveTo(Room.SOUTH);
                     break;

                 // Exit
                 case "q": case "esci": case "quit":
                     io.println("Grazie per aver giocato");
                     return;

                 // Look / Guarda
                 case "g": case "guarda": case "look":
                     continue; // just loop to print room again

                 // Prendi (take) - with prefix matching
                 case "p": case "prendi": case "take":
                     if(arg.isEmpty()){
                         io.println("Prendi cosa?");
                     } else {
                         Item it = current.findItemByPrefix(arg);
                         if(it!=null){
                             current.removeItemByName(it.getName());
                             player.pickUp(it);
                             io.println("Hai preso: " + it.getName());
                         } else {
                             io.println("Non c'è questo oggetto qui: " + arg);
                         }
                     }
                     continue;

                 // Getta (drop) - with prefix matching
                 case "d": case "getta": case "drop":
                     if(arg.isEmpty()){
                         io.println("Getta cosa?");
                     } else {
                         var dropped = player.dropByPrefix(arg);
                         if(dropped.isPresent()){
                             current.addItem(dropped.get());
                             io.println("Hai gettato: " + dropped.get().getName());
                         } else {
                             io.println("Non hai questo oggetto: " + arg);
                         }
                     }
                     continue;

                 // Inventario
                 case "i": case "inventario": case "inv": case "inventory":
                     io.println("Inventario: " + player.getInventoryNames());
                     continue;

                 // Equipaggia - with prefix matching
                 case "eq": case "equipaggia": case "equip":
                     if(arg.isEmpty()){
                         io.println("Equipaggia cosa?");
                     } else {
                         boolean ok = player.equipByPrefix(arg);
                         if(ok) io.println("Equipaggiato!");
                         else io.println("Non trovato nell'inventario: " + arg);
                     }
                     continue;

                 // Parla (talk)
                 case "pa": case "parla": case "talk":
                     if(arg.isEmpty()){
                         io.println("Parlare con chi?");
                     } else {
                         Entity entity = current.findEntityByPrefix(arg);
                         if(entity!=null && entity!=player){
                             io.println("Parli con " + entity.getName() + " (ma non risponde)");
                         } else {
                             io.println("Non vedo '" + arg + "' qui.");
                         }
                     }
                     continue;

                 // Attacca (attack) - with prefix matching
                 case "at": case "attacca": case "attack":
                     if(arg.isEmpty()){
                         io.println("Attaccare chi?");
                     } else {
                         Entity target = current.findEntityByPrefix(arg);
                         if(target==null || target==player){
                             io.println("Non vedo '" + arg + "' qui.");
                         } else {
                             int dmg = 5;
                             boolean dead = target.applyDamage(dmg);
                             io.println("Hai inflitto " + dmg + " danni a " + target.getName());
                             if(dead){
                                 io.println(target.getName() + " è morto.");
                                 current.removeEntity(target);
                             }
                         }
                     }
                     continue;

                 // Help
                 case "h": case "aiuto": case "help":
                     printHelp();
                     continue;

                 default:
                     io.println("Non ho capito che cosa vuoi! (digita 'aiuto' per i comandi)");
                     continue;
             }

             if(moved){
                 io.println("Ti muovi verso " + getDirectionName(verb));
             } else if(isMovementCommand(verb)){
                 io.println("Non c'è nulla in quella direzione");
             }
         }
     }

     private String getDirectionName(String verb){
         switch(verb){
             case "n": case "nord": return "nord";
             case "s": case "sud": return "sud";
             case "e": case "est": return "est";
             case "o": case "ovest": return "ovest";
             default: return verb;
         }
     }

     private boolean isMovementCommand(String verb){
         return verb.equals("n") || verb.equals("nord") || verb.equals("north") ||
                verb.equals("s") || verb.equals("sud") || verb.equals("south") ||
                verb.equals("e") || verb.equals("est") || verb.equals("east") ||
                verb.equals("o") || verb.equals("ovest") || verb.equals("west");
     }

     private void printHelp(){
         io.println("""
                 === COMANDI ===
                 Movimento: n/nord, s/sud, e/est, o/ovest
                 
                 Oggetti:
                   p / prendi <oggetto> - Prendi un oggetto
                   d / getta <oggetto>  - Getta un oggetto
                   i / inventario       - Mostra inventario
                   eq / equipaggia <oggetto> - Equipaggia un oggetto
                 
                 Interazione:
                   pa / parla <personaggio>  - Parla con un personaggio
                   at / attacca <nemico>     - Attacca un nemico
                 
                 Altro:
                   g / guarda - Mostra stanza
                   h / aiuto  - Questo messaggio
                   q / esci   - Esci dal gioco
                 
                 NOTA: I nomi di oggetti e personaggi rispondono a prefix matching!
                 Es: "p man" per "prendi Mela", "at lup" per "attacca Lupo Solitario"
                 """
         );
     }

    private boolean moveTo(int direction) {
        Room destination = current.exitAt(direction);
        if(destination != null){
            current = destination;
            return true;
        }
        return false;
    }

    public void main(){
        World w = new World();
        w.startGame();
    }
}