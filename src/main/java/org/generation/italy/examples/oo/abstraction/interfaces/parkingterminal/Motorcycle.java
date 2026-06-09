package org.generation.italy.examples.oo.abstraction.interfaces.parkingterminal;

public class Motorcycle implements Vehicle{
    public String model;
    public String color;
    private double taxPark;
    private String plate;

    public Motorcycle(String model, String color){
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void findVehicle() {
        System.out.printf("Hai trovato la moto %s %s", model,color);
    }

    @Override
    public void parkVehicle() {
        System.out.printf("La moto %s %s è parcheggiata al numero %d", model, color, 45);
    }

    @Override
    public void payForVehicle() {
        System.out.println("Devi pagare 3,58 euro");
    }

    @Override
    public String getPlate() {
        return"";
    }
}
