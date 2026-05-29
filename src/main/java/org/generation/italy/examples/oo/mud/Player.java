package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Entity {
    private Random luck= new Random();
    private ArrayList<Item> inventory=new ArrayList<>();

    public Player(String name){
        super(name,1,10,100);

    }
    public String showInventory(){
        String msg="L'INVENTARIO E' VUOTO";
        if(inventory.isEmpty()) return result;
        IO.println("INVENTARIO: ");
        System.out.printf("%-20s | %-20s| %-20s|","ITEM","VALORE","PESO");
        for(Item i: inventory){
            System.out.printf("%-20s | %-20d| %-20d| %n",i.getName(),i.getValue(),i.getWeight());
        }
        switch (Player.choice("Per droppare un item selezionare D \n" +
                                    "Per uscire dall'inventario selezionare E\n" +
                                    "",{"d","e"}))
    }
    public static String choice(String msg,String[] options){
        String selected=IO.readln(msg);
        boolean validSelection=false;
        for(String s : options){
            if(selected.equalsIgnoreCase(s)){
                validSelection=true;
                break;
            }
        }
        if(validSelection) return selected;
        return Player.choice("SCELTA NON VALIDA \n"+msg,options);
    }

}
