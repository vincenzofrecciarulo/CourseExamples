package org.generation.italy.examples.oo.mud;

public class Item {
    private String name;
    private double value;
    private double weight;
    private boolean droppable;
    private int id;

    public Item(String name, double value, double weight, boolean droppable, int id) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.droppable = droppable;
    }
    public Item(String name, double value, double weight, int id){
        this(name,value,weight,true,id);
    }
    public Item(String name, double value, int id){
        this(name,value,1,id);
    }

    @Override
    public boolean equals(Object o){
        return this.getId()==((Item)o).getId();
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
    public int getId(){return id;}

}
