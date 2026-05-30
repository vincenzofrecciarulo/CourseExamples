package org.generation.italy.examples.oo.mud;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    // public String name;      dare nome all'inizio, aggiungere epiteti durante il gioco
    //public int level = 1;           aumentare punti, vedi se magari è figlia di entity

    public int hp = 100;
    public int damage = 5;
    ArrayList<Item> playerItems = new ArrayList<>();

    Inventory inventoryPlayer = new Inventory(playerItems, 0, 50);

    Item woodenSword = new Item(5,3,"Spada di legno");
    boolean success = inventoryPlayer.addToInventory(woodenSword);


}
