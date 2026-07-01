package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.entities.Entity;
import org.generation.italy.examples.oo.mud.items.Item;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north,south,east,west;
    private ArrayList<Item> roomItems = new ArrayList<>();
    private ArrayList<Entity> population = new ArrayList<>();
    boolean keepMenu=true;

    public Room(String name,String description,Room north,Room south,Room east,Room west){
        this.name=name;
        this.description=description;
        this.north=north;
        this.south=south;
        this.east=east;
        this.west=west;
    }
    public Room(String name,String description){
        this(name,description,null,null,null,null);
    }
    public void populate(Entity entity){
        population.add(entity);
    }
    public Entity[] getPopulation(){
        return population.toArray(new Entity[0]);
    }
    public void kickOut(Entity entity){
        population.remove(entity);
    }
    public int getHostileCount() {
        int count = 0;
        for (Entity e : population) {
            if (e.isHostile()) {
                count++;
            }
        }
        return count;
    }
    public boolean isEmpty(){
        return population.isEmpty();
    }
    public boolean addItem(Item item){
        this.roomItems.add(item);
        return true;
    }
    public Item removeItem(String toRemove){
        Item removed=null;
        for(Item i: roomItems){
            if(i.isNamed(toRemove)) {
                removed=i;
                roomItems.remove(i);
                break;
            }
        }
        return removed;
    }
    public String showItems(){
        StringBuilder sb=new StringBuilder();
        String msg="LA STANZA E' VUOTA";
        if(roomItems.isEmpty()) return msg;
        sb.append("GUARDANDO A TERRA NOTI: ");
        sb.append(String.format("\n%-20s | %-20s| %-20s|","ITEM","VALORE","PESO"));
        for(Item i: roomItems){
            sb.append(String.format("%-20s | %-20.2f| %-20.2f| %n",i.getName(),i.getValue(),i.getWeight()));
        }
        msg=sb.toString();
        return msg;
    }
    public String showPopulation() {
        StringBuilder sb = new StringBuilder();
        if (population.isEmpty()) {
            return "";
        }
        sb.append("ENTITA' PRESENTI: \n");
        for (Entity e : population) {
            sb.append("- ").append(e.getName()).append(" [Lvl ").append(e.getLevel()).append("]\n");
        }
        return sb.toString();
    }

    public Room getExitAt(String direction){
        switch(direction.toLowerCase()){
            case "n":
                return north;
            case "s":
                return south;
            case "e":
                return east;
            case "w":
                return west;
            default: return null;
        }
    }
    public boolean setExit(Room exit,String direction){
        boolean success=false;
        if(getExitAt(direction)==null){
            success=true;
            switch(direction.toLowerCase()) {
                case "n":
                    this.setNorth(exit);
                    exit.setSouth(this);
                    break;
                case "s":
                    this.setSouth(exit);
                    exit.setNorth(this);
                    break;
                case "e":
                    this.setEast(exit);
                    exit.setWest(this);
                    break;
                case "w":
                    this.setWest(exit);
                    exit.setEast(this);
                    break;
                default:
                    return false;
            }
        }
        return success;
    }
    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
    public boolean hasItems() {
        if(roomItems.isEmpty()) return false;
        else return true;
    }

    public Item[] getRoomItems() {
        return roomItems.toArray(new Item[0]);
    }
}
