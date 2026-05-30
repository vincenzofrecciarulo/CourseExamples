package org.generation.italy.examples.oo.mud;

public class Item {
    private String name;
    private double value;
    private double weight;
    private boolean droppable;

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
    public boolean isNamed(String item){
        return this.getName().equalsIgnoreCase(item);
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

}
