package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.commands.*;
import org.generation.italy.examples.oo.mud.roles.CharacterClass;
import org.generation.italy.examples.oo.mud.roles.CharacterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private final Room start;
    private final GameIO io;
    private final CommandRegistry commands;
    private final CharacterFactory characterFactory;

    public World(){
        this(new ConsoleIO());
    }

    /**
     * Create a world using a provided GameIO (useful for tests)
     */
    public World(GameIO io){
         this.io = io;
         this.characterFactory = new CharacterFactory(new Random());
         this.commands = createCommands();
         // Build a richer fantasy city map following a north-south vertical axis

         // NORTHMOST: Foresta Profonda (Deep Forest)
         Room df = new Room("Foresta Profonda",
                 """
                         Alberi secolari, il suono degli animali e un senso di mistero. Meglio non avventurarsi da soli.
                         """, new ArrayList<>(), new ArrayList<>());

         // Populate deep forest
         df.addEntity(new Monster(12, "Lupo Solitario", 2, 4));
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

         am.addEntity(new Npc(35, "Mastro Armaiolo", 6, "Se ti serve una lama ben fatta, sei nel posto giusto."));

         // Fucina Laterale (Side Smithy) - WEST of Armeria
         Room fucina = new Room("Fucina Laterale",
                 """
                         Una piccola fucina dove si riparano armi e armature. Il fuoco arde costante.
                         """, new ArrayList<>(), new ArrayList<>());

         // Piazza del Tempio (Temple Square) - south of Armeria
         ArrayList<Entity> templeEntities = new ArrayList<>();
         templeEntities.add(new Npc(30, "Sacerdote Anziano", 6, "La fede richiede pazienza, disciplina e silenzio."));
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
         libEntities.add(new Npc(20, "Vecchio Saggio", 8, "Ogni libro è una porta. Alcune portano lontano."));
         ArrayList<Item> libItems = new ArrayList<>();
         libItems.add(new Item(0.1, 12, "Pergamena Antica"));
         Room lib = new Room("Biblioteca della Città",
                 """
                         Scaffali alti pieni di libri, volumi polverosi e tavolette di studio.
                         Chi cerca conoscenza spesso si ferma qui per ore.
                         """, libEntities, libItems);

         lib.addEntity(new Npc(18, "Apprendista Bibliotecario", 2, "Sto ancora imparando a trovare i tomi giusti."));

         // Forno di Lieta (Bakery) - WEST of Piazza del Tempio
         ArrayList<Item> bakeryItems = new ArrayList<>();
         bakeryItems.add(new Item(0.4, 5, "Pagnotta Calda"));
         bakeryItems.add(new Item(0.2, 2, "Fetta di Pane"));
         Room bk = new Room("Forno di Lieta",
                 """
                         Una piccola bottega dove il pane sfornato attira clienti: il profumo è irresistibile.
                         """, new ArrayList<>(), bakeryItems);

         bk.addEntity(new Npc(22, "Fornaio", 3, "Il pane migliore è quello caldo, appena sfornato."));

         // Piazza del Mercato (Market Square) - SOUTH of Piazza del Tempio (START)
         ArrayList<Entity> marketEntities = new ArrayList<>();
         marketEntities.add(new Npc(40, "Guardia del Mercato", 5, "Tieni gli occhi aperti e le mani lontane dalle merci."));
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
         tavEntities.add(new Npc(25, "Oste Burlone", 3, "Una storia migliore si serve con un bicchiere pieno."));
         ArrayList<Item> tavItems = new ArrayList<>();
         tavItems.add(new Item(0.3, 3, "Fiaschetta di vino"));
         Room tv = new Room("Taverna del Pugnale Rosso",
                 """
                         Odore di birra e carne al fuoco. Avventurieri e mercanti si scambiano voci di tesori.
                         Il bardo sta intonando una canzone al bancone.
                         """, tavEntities, tavItems);

         // Molo (Docks) - EAST of Piazza del Mercato
         ArrayList<Entity> dockEntities = new ArrayList<>();
         dockEntities.add(new Npc(20, "Capitano del Porto", 4, "Il porto non dorme mai, e neppure io."));
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

         gd.addEntity(new Monster(8, "Capo Goblin", 4, 5));
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
         Player player = createInitialPlayer();
         GameContext context = new GameContext(io, start, player);
         CombatCoordinator combatCoordinator = new CombatCoordinator(context, io);
         context.setCombatCoordinator(combatCoordinator);
         // create a default player and put into the start room
         context.getCurrentRoom().addEntity(player);

         renderCurrentRoom(context);

         while(true){
             if(combatCoordinator.isGameOver()){
                 return;
             }

             String prompt = combatCoordinator.isCombatActive() ? "combattimento> " : "-> ";
             String line = io.readln(prompt);
             if(line==null) break;
             String command = line.trim();
             if(command.isEmpty()) continue;

             if(combatCoordinator.isCombatActive()){
                 combatCoordinator.enqueueInput(command);
                 continue;
             }

             String[] parts = command.split("\\s+", 2);
             String verb = parts[0].toLowerCase();
             String arg = parts.length>1? parts[1].trim():"";

             Command handler = commands.get(verb);
             if(handler == null){
                 io.println("Non ho capito che cosa vuoi! (digita 'aiuto' per i comandi)");
                 renderCurrentRoom(context);
                 continue;
             }

             CommandOutcome outcome = handler.execute(context, arg);
             if(outcome == CommandOutcome.QUIT){
                 return;
             }
             if(outcome == CommandOutcome.REFRESH){
                 renderCurrentRoom(context);
             }
         }
     }

     private CommandRegistry createCommands() {
         MoveCommand north = new MoveCommand(Room.NORTH, "nord");
         MoveCommand east = new MoveCommand(Room.EAST, "est");
         MoveCommand west = new MoveCommand(Room.WEST, "ovest");
         MoveCommand south = new MoveCommand(Room.SOUTH, "sud");
         QuitCommand quit = new QuitCommand();
         LookCommand look = new LookCommand();
         TakeCommand take = new TakeCommand();
         DropCommand drop = new DropCommand();
         InventoryCommand inventory = new InventoryCommand();
         EquipCommand equip = new EquipCommand();
         TalkCommand talk = new TalkCommand();
         AttackCommand attack = new AttackCommand();
         HelpCommand help = new HelpCommand();
         AbilityCommand ability = new AbilityCommand();
         CharacterSheetCommand characterSheet = new CharacterSheetCommand();

         return new CommandRegistry()
                 .register("n", north)
                 .register("nord", north)
                 .register("north", north)
                 .register("e", east)
                 .register("est", east)
                 .register("east", east)
                 .register("w", west)
                 .register("ovest", west)
                 .register("west", west)
                 .register("s", south)
                 .register("sud", south)
                 .register("south", south)
                 .register("q", quit)
                 .register("esci", quit)
                 .register("quit", quit)
                 .register("g", look)
                 .register("guarda", look)
                 .register("look", look)
                 .register("p", take)
                 .register("prendi", take)
                 .register("take", take)
                 .register("d", drop)
                 .register("getta", drop)
                 .register("drop", drop)
                 .register("i", inventory)
                 .register("inventario", inventory)
                 .register("inv", inventory)
                 .register("inventory", inventory)
                 .register("eq", equip)
                 .register("equipaggia", equip)
                 .register("equip", equip)
                 .register("pa", talk)
                 .register("parla", talk)
                 .register("talk", talk)
                 .register("at", attack)
                 .register("attacca", attack)
                 .register("attack", attack)
                 .register("abilita", ability)
                 .register("skill", ability)
                 .register("usa", ability)
                 .register("scheda", characterSheet)
                 .register("stats", characterSheet)
                 .register("h", help)
                 .register("aiuto", help)
                 .register("help", help);
     }

     private Player createInitialPlayer() {
         io.println("Crea il tuo personaggio.");
         List<CharacterClass> characterClasses = characterFactory.availableClasses();
         for(int i = 0; i < characterClasses.size(); i++){
             CharacterClass characterClass = characterClasses.get(i);
             io.println((i + 1) + ". " + characterClass.getName() + " - " + characterClass.getDescription());
         }

         String name = io.readln("Nome del personaggio [Avventuriero]: ");
         if(name == null || name.isBlank()){
             name = "Avventuriero";
         } else {
             name = name.trim();
         }

         int chosenClassIndex = chooseClassIndex();
         CharacterClass characterClass = characterClasses.get(chosenClassIndex - 1);

         Player player = characterFactory.create(name, 1, characterClass);
         io.println("Personaggio creato: " + player.getName() + " (" + characterClass.getName() + ")");
         io.println("Statistiche iniziali: " + player.getStats());
         return player;
     }

     private int chooseClassIndex() {
         while(true){
             String input = io.readln("Scegli la classe [1-" + characterFactory.availableClasses().size() + "]: ");
             if(input == null || input.isBlank()){
                 return 1;
             }

             try {
                 int value = Integer.parseInt(input.trim());
                 if(value >= 1 && value <= characterFactory.availableClasses().size()){
                     return value;
                 }
             } catch (NumberFormatException ignored) {
                 // Proviamo di nuovo se l'input non e' un numero valido.
             }

             io.println("Scelta non valida, riprova.");
         }
     }

     private void renderCurrentRoom(GameContext context) {
         io.println(context.getCurrentRoom().toString());
     }

}
