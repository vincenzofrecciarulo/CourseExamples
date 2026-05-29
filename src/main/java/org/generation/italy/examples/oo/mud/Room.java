package org.generation.italy.examples.oo.mud;

public class Room {
    private String name;
    private String description;
    private Room north,south,east,west;

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

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Room getExitAt(String direction){
        switch(direction.toLowerCase()){
            case "n":
                return (!north.equals(null)? north : this);
            case "s":
                return (!south.equals(null)? south : this);
            case "e":
                return (!east.equals(null)? east : this);
            case "w":
                return (!west.equals(null)? west : this);
            default: return null;
        }
    }
    public boolean setExit(Room exit,String direction){
        boolean set=false;

    }

}
