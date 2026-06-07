package org.generation.italy.examples.oo.cardealer;

public class Car implements Vehicle{
    private String plate;
    private String color;
    private int doors;

    public Car(String plate, String color, int doors){
        this.plate = plate;
        this.color = color;
        this.doors = doors;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    @Override
    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    @Override
    public void printInfo() {
        System.out.println("Plate: "+getPlate()+"\nColor: "+getColor()+"\nDoors: "+getDoors());
    }
}
