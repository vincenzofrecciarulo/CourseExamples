package org.generation.italy.examples.oo.abstraction.interfaces.parkingterminal;

public class Car implements Vehicle{
    public String model;
    public String color;
    private double taxPark;
    private String plate;

    public Car(String model, String color){
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void findVehicle() {
        System.out.printf("Hai trovato la macchina %s %s", model,color);
    }

    @Override
    public void parkVehicle() {
        System.out.printf("La macchina %s %s è parcheggiata al numero %d", model, color, 14);
    }

    @Override
    public void payForVehicle() {
        System.out.printf("Devi pagare %d euro", taxPark);
    }

    @Override
    public String getPlate() {
        return plate;
    }
}
