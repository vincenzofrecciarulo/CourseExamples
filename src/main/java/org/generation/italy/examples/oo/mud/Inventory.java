package org.generation.italy.examples.oo.mud;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private static final int MAXWEIGHT=20;

    private double sumWeights() {
        double sum=0;
        for (Item i : items){
            sum+= i.getWeight();
        }
        return sum;
    }


    public Inventory(ArrayList<Item> items){
        this.items =items;
    }

    public boolean addItem(Item itemToAdd){
        //ArrayList<Item> updatedItems = items;
        if (sumWeights()+itemToAdd.getWeight()<MAXWEIGHT){
            items.add(itemToAdd);
            return true;
        } else {return false;}
    }

    public Item removeItem(String nameItemToRemove){
        for (Item i:items){
            if(nameItemToRemove.equals(i.getName())){
                items.remove(i);
                return i;
            }
        }
        return null;
    }

    public String printInventory(){
        ArrayList<String> printedInventory = new ArrayList<String>();
        for (Item i:items){
            printedInventory.add("Nome oggetto: "+i.getName()+ "; Peso: " +i.getWeight()+ "; Valore: "+i.getValue());
        }
        return String.join("\n",printedInventory);
    }

}
