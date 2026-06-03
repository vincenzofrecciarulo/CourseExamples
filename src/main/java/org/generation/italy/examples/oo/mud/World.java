package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;
    private Player player;

    public World(){

        //---------AGORA-----------
        ArrayList<Entity> es = new ArrayList<>();

        ArrayList<Move> mosseOreste= new ArrayList<>();
        mosseOreste.add(new Move("Ingenuità disarmante", 4, "Ti fa una domanda così ingenua che ti blocchi."));
        mosseOreste.add(new Move("Pianto", 3, "Piange. Troppa perturbabilità ferisce la tua ragione."));

        Item rewardOreste = new Item(2,10,"Moneta da 10 dracme");
        ArrayList<String> optionsOreste= new ArrayList<>();
        optionsOreste.add("1: E se fosse tutto un sogno? ");
        optionsOreste.add("2: I sensi ingannano, solo la ragione guida. ");
        optionsOreste.add("3: Magari siamo solo ombre in una caverna. ");

        Question questionOreste = new Question("Come potrei mai dubitare che il mondo esiste? "+"\n"+"Che si rimbocchino le maniche questi filosofastri. ", optionsOreste, -1, rewardOreste);

        es.add(new Entity(20, "Oreste il naïve", 2, mosseOreste, questionOreste));
        //es.add(new Entity(20, "Oreste il naïve", 2));

        ArrayList<Item> os = new ArrayList<>();
        os.add(new Item(5, 3, "Pentola di lenticchie"));
        os.add(new Item(2, 1, "Bastone di legno"));

        Room agorà = new Room("Agorà",
                """
                        Vociare confuso e gente accalcata: sei nell'Agorà, 
                        la piazza dove la città si affacenda e, ogni tanto, 
                        si ferma a pensare.
                        Tra colonne consumate e capannelli di gente che discute, 
                        qui ogni domanda trova qualcuno pronto a metterla in dubbio.
                        """, es, os
        );

        start = agorà;

        //----------TEMPIO-----------
        ArrayList<Entity> es2 = new ArrayList<>();

        ArrayList<Move> mosseCassandra = new ArrayList<>();
        mosseCassandra.add(new Move("Profezia funesta", 10, "Ti rivela il tuo futuro e la scoperta ti acceca."));
        mosseCassandra.add(new Move("Invocazione ad Atena", 9, "Una preghiera che pesa come un macigno."));
        mosseCassandra.add(new Move("Maledizione inascoltata", 5, "Nessuno le crede, ma fa male lo stesso."));

        Item rewardCassandra = new Item(0.5,50,"Frammento di profezia: una verità scritta che nessuno ha mai letto. ");
        ArrayList<String> optionsCassandra= new ArrayList<>();
        optionsCassandra.add("1: Dipende...");
        optionsCassandra.add("2: Conoscerla e non poterla condividere.");
        optionsCassandra.add("3: Non conoscerla.");

        Question questionCassandra = new Question("Chi vede tutto ma non viene creduta conosce la peggiore delle solitudini. Dimmi: è peggio non conoscere la verità, o conoscerla e non poterla condividere?", optionsCassandra, 2, rewardCassandra);

        es2.add(new Entity(20, "Cassandra la Sacerdotessa", 50, mosseCassandra, questionCassandra));

        //es2.add(new Entity(20, "Cassandra la Sacerdotessa", 50));

        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(1, 20, "Ramo d'ulivo sacro"));

        Room tempioDiAtena = new Room("Tempio di Atena",
                """
                        Entri nel Tempio di Atena. 
                        Il chiasso dell'Agorà resta fuori: 
                        qui c'è solo penombra fresca, l'odore dell'incenso e lo sguardo di pietra della dea, 
                        che sembra soppesare ogni tuo pensiero.
                        """, es2, os2
        );

        agorà.addExit(tempioDiAtena, Room.NORTH);
        tempioDiAtena.addExit(agorà, Room.SOUTH);


        //---------CASA-----------
        ArrayList<Entity> es3 = new ArrayList<>();

        ArrayList<Move> mosseIgnazio = new ArrayList<>();
        mosseIgnazio.add(new Move("Sofisma", 5, "Prinuncia un ragionamento che sembra giusto ma non lo è, eppure confonde."));
        mosseIgnazio.add(new Move("Eristica", 4, "Discute solo per vincere, non per capire. Questo ti urta nel profondo."));
        mosseIgnazio.add(new Move("Argomento ad hominem", 3, "Prende in giro i tuoi gusti per screditarti...che colpo basso. "));

        Item rewardIgnazio = new Item(1.5,25,"Anello dell'astuzia");
        ArrayList<String> optionsIgnazio= new ArrayList<>();
        optionsIgnazio.add("1: Qualsiasi cosa. ");
        optionsIgnazio.add("2: Tenerlo, perché così il padre ha torto. ");
        optionsIgnazio.add("3: Restituirlo, perché il padre ha indovinato. ");

        Question questionIgnazio = new Question("Salve collega pensatore, ho un indovinello per te:"+"\n"+"Un coccodrillo rapisce un bambino e dice al padre: 'Te lo restituisco se indovini cosa farò.' "+"\n"+"Il padre risponde: 'Non me lo restituirai.' "+"\n"+"Che deve fare il coccodrillo? ", optionsIgnazio, 0, rewardIgnazio);

        es3.add(new Entity(13, "Ignazio il topo sofista", 10, mosseIgnazio, questionIgnazio));

        //es3.add(new Entity(5, "Ignazio il topo sofista", 3));

        ArrayList<Item> os3 = new ArrayList<>();
        os3.add(new Item(2, 10, "Libro 'De Natura' "));

        Room casa = new Room("Casa",
                """
                        Sei a casa. Poco importa se è grande o piccola: c'è quello che ti serve per pensare, e nient'altro.
                        """, es3, os3
        );

        agorà.addExit(casa, Room.EAST);
        casa.addExit(agorà, Room.WEST);


    }

    public void startGame(){
        //Player player = new Player(IO.readln("Come ti chiami?"), chooseRole());  // riga attuale
        this.player = new Player(IO.readln("Come ti chiami?"), chooseRole());
        current = start;
        while(true){
            // IO.println(current.getTitle());
            // IO.println(current.getDescription());
            IO.println(current); // questo fa automaticamente toString
            String command = IO.readln("->");
            boolean success = false;
            switch(command.toLowerCase()) {
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
                case "q":
                    IO.println("Grazie per aver giocato");
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

    private boolean moveTo(int direction) {
        Room destination = current.exitAt(direction);
        if(destination != null){
            current = destination;
            return true;
        }
        return false;
    }



    public Role chooseRole(){
        boolean notChosenYet=true;
        Role role=null;
        while (notChosenYet){
            String roleString=IO.readln("""
                        Con che scuola di pensiero ti identifichi?
                        Stoicismo (1), Epicureismo (2) o Cinismo (3)?
                        """).toLowerCase();
            switch (roleString){
                case "3":
                    role=Role.CINICO;
                    IO.println(
                            """
                            Complimenti, brutta canaglia! 
                            Vivi in una botte e il tuo motto è:      
                            """+"\n"+Role.CINICO.getMotto()
                            );
                    break;
                case "1":
                    role=Role.STOICO;
                    IO.println(
                            """
                            La perturbabilità non ti fa un baffo. 
                            Vivi nella  Stoà e il tuo motto è:
                            """+"\n"+Role.STOICO.getMotto()
                            );
                    break;
                case "2":
                    role=Role.EPICUREO;
                    IO.println(
                            """
                            Nonostante la gente pensi il contrario, sei una persona seria. 
                            Vivi in un ostello e il tuo motto è:                                    
                            """+"\n"+Role.EPICUREO.getMotto()
                            );
                    break;
                default:
                    IO.println("Scelta non valida");
                    continue;
            }
            if (role != null){
                notChosenYet=false;
            }
        }
        return role;
    }
}