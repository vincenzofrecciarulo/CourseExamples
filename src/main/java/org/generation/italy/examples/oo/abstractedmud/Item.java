package org.generation.italy.examples.oo.abstractedmud;

import org.generation.italy.examples.oo.mud.entities.Player;

public abstract class Item {
    private String name;
    private double value;
    private boolean droppable;
    protected char type;
    private boolean inUse=false;
    public Item(String name, double value, boolean droppable) {
        this.name = name;
        this.value = value;
        this.droppable = droppable;
    }
    public Item(String name, double value){
        this(name,value,true);
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    @Override
    public boolean equals(Object o){
        return this.getName().equalsIgnoreCase(((Item)o).getName());
    }
    public boolean isNamed(String name){
        return this.getName().equalsIgnoreCase(name);
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

    public boolean isInUse() {
        return inUse;
    }

    public char getType() {
        return type;
    }
}
