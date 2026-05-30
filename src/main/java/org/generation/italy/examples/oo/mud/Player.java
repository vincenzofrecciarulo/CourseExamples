package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Entity {
    private Random luck= new Random();
    private ArrayList<Item> inventory=new ArrayList<>();
    private final int INVENTORY_SLOTS= 20;
    boolean keepMenu=true;

    public Player(String name,Room startingRoom){
        super(name,1,10,100,startingRoom);

    }
    public String showInventory(){
        String msg="L'INVENTARIO E' VUOTO";
        if(inventory.isEmpty()) return msg;
        IO.println("INVENTARIO: ");
        System.out.printf("%-20s | %-20s| %-20s|","ITEM","VALORE","PESO");
        for(Item i: inventory){
            System.out.printf("%-20s | %-20.2f| %-20.2f| %n",i.getName(),i.getValue(),i.getWeight());
        }
        keepMenu=true;
        do{
            msg="Per droppare un item selezionare D \n" +
                "Per uscire dall'inventario selezionare E\n" +
                "Per guardarti intorno L";
            switch(Utils.choice(msg,"d","e","l")){
                case "d":

                    msg=this.dropItem(Utils.choice("Inserire il nome dell'item da eliminare",));
                    break;
                case"e":
                    keepMenu=false;
                    break;
                case"l":
                    keepMenu=false;
                    msg=getCurrentRoom().showItems();
                    break;
            }
        }while(keepMenu);
        return msg;
    }
    public  String dropItem(String item){
        boolean removed=false;
        StringBuilder sb=new StringBuilder();
        for (Item i: inventory){
            if(i.isNamed(item) ){
                if(i.isDroppable()) {
                    getCurrentRoom().addItem(i);
                    removed = inventory.remove(i);
                    sb.append(String.format("Item %s rimosso dall'inventario\n",item));
                    break;
                }else sb.append(String.format("Item %s non puo' essere rimosso dall'inventario",item));
            }
        }
        if(!removed) sb.append(String.format("Item %s non e' presente nell'inventario",item));

        return sb.toString();
    }


}
