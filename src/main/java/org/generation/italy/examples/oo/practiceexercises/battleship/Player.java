package org.generation.italy.examples.oo.practiceexercises.battleship;

import java.util.ArrayList;
import java.util.List;

/*Giochiamo contro il pc, per giocare ci serve un player, le navi e una tabella

Classe Player -> nome, Lista di navi?

Classe Nave -> dimensione intesa come spazio e orientamento, Map<String,Intger> coordinate  ?

Classe Tabella -> Dimensione tabella (10x10) dividiamo lettere per numeri ?, condizione della partita ?

Inizia il gioco -> player 1 sceglie le navi / o dove metterle -> player decide dove la posizione
delle navi sulla tabella
-> inserisce una cordinata(puo esser una matrice o una Mappa?) ->
la Cpu/rivale gli vengono messe casualmente ->
il player scriverà dove vuole sparare (Es. b,4) -> se la posizione è uguale a una coordinata della nave ->
 se la nave è di grandezza 1 viene rimossa dalla tabella -> se il player becca una parte della nave continua
 sparare -> se non trova nulla passa il turno
 */
public class Player {

    private String name;
    private List<Boat> boats;
    private Grid playerGrid;
    private Grid attackGrid;

    public Player(String name,List<Boat>boats,Grid playerGrid) {
        this.name = name;
        this.boats=new ArrayList<>();
        this.playerGrid=playerGrid;
        populateBoats();
    }

    private void populateBoats() {
        boats.add(new Boat(BoatTypes.BIG));
        boats.add(new Boat(BoatTypes.MEDIUM));
        boats.add(new Boat(BoatTypes.MEDIUM));
        boats.add(new Boat(BoatTypes.SMALL));
        boats.add(new Boat(BoatTypes.SMALL));

    }

    public void setPlayerGrid(Grid playerGrid) {
        this.playerGrid = playerGrid;
    }

    public Grid getPlayerGrid() {
        return playerGrid;
    }

    public String getName() {
        return name;
    }

    public List<Boat> getBoats() {
        return boats;
    }
}
