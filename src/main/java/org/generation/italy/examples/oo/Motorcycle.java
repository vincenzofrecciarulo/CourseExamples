package org.generation.italy.examples.oo;

public class Motorcycle implements Vehicle{
    private String plate;
    private String color;
    private String accessories;
    private boolean hasSidecar;

    public Motorcycle(String plate, String color, String accessories, boolean hasSidecar) {
        this.accessories = accessories;
        this.hasSidecar = hasSidecar;
        this.plate = plate;
        this.color = color;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public String getAccessories() {
        return accessories;
    }

    @Override
    public void printInfo() {
        System.out.println("Plate: "+getPlate()+"\nColor: "+getColor()+"\nSidecar: "+hasSidecar+"\nAccessories: "+getAccessories());
    }

}
