package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class World {
    private Room start;
    private Room current;
    private Player player;

    public World(){

        //---------AGORA-----------
        ArrayList<Entity> es = new ArrayList<>();
        es.add(new Entity(20, "Ciro il naïve", 2));

        ArrayList<Item> os = new ArrayList<>();
        os.add(new Item(5, 3, "Pentola di lenticchie"));
        os.add(new Item(2, 1, "Bastone di legno"));

        Room agorà = new Room("Agorà",
                """
                        Vociare confuso e gente accalcata: sei nell'Agorà, 
                        la piazza dove la città si affacenda e, meno spesso di quanto si pensi, 
                        si ferma a pensare.
                        Tra colonne consumate e capannelli di gente che discute, 
                        qui ogni domanda trova qualcuno pronto a metterla in dubbio.
                        """, es, os
        );

        start = agorà;

        //----------TEMPIO-----------
        ArrayList<Entity> es2 = new ArrayList<>();
        es2.add(new Entity(20, "Cassandra la Sacerdotessa", 100));

        ArrayList<Item> os2 = new ArrayList<>();
        os2.add(new Item(1, 8, "Penna"));

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
        es3.add(new Entity(5, "Ignazio il topo sofista", 3));

        ArrayList<Item> os3 = new ArrayList<>();
        os3.add(new Item(2, 10, "Ethica di Baruch Spinoza"));

        Room casa = new Room("Casa",
                """
                        Sei a casa.
                        """, es3, os3
        );

        agorà.addExit(casa, Room.EAST);
        casa.addExit(agorà, Room.WEST);


    }

    public void startGame(){
        Player player = new Player(IO.readln("Come ti chiami?"), chooseRole());  // riga attuale
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
                        Stoicismo (s), Epicureismo (e) o Cinismo (c)?
                        """).toLowerCase();
            switch (roleString){
                case "c":
                    role=Role.CINICO;
                    IO.println(
                            """
                            Complimenti, brutta canaglia! 
                            Vivi in una botte e il tuo motto è:      
                            """+"\n"+Role.CINICO.getMotto()
                            );
                    break;
                case "s":
                    role=Role.STOICO;
                    IO.println(
                            """
                            La perturbabilità non ti fa un baffo. 
                            Vivi nella  Stoà e il tuo motto è:
                            """+"\n"+Role.STOICO.getMotto()
                            );
                    break;
                case "e":
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