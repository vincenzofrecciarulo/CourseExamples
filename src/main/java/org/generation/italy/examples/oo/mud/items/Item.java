package org.generation.italy.examples.oo.mud.items;

import org.generation.italy.examples.oo.mud.entities.Player;

public class Item {
    private String name;
    private double value;
    private double weight;
    private boolean droppable;
    protected char type;
    private boolean inUse=false;
    public Item(String name, double value, double weight, boolean droppable) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.droppable = droppable;
    }
    public Item(String name, double value, double weight){
        this(name,value,weight,true);
    }
    public Item(String name, double value){
        this(name,value,1);
    }

    @Override
    public boolean equals(Object o){
        return this.getName().equalsIgnoreCase(((Item)o).getName());
    }
    public boolean isNamed(String name){
        return this.getName().equalsIgnoreCase(name);
    }
    public String use(Player player) {
        this.inUse=true;
        return "Questo oggetto non può essere usato direttamente.";
    }
    public String unUse(Player player){
        this.inUse=false;
        return "Non hai piu' questo oggetto in mano";
    }

    public boolean isDroppable(){
        return droppable;
    }
    public String getName(){
        return name;
    }
    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isInUse() {
        return inUse;
    }

    public char getType() {
        return type;
    }
}
