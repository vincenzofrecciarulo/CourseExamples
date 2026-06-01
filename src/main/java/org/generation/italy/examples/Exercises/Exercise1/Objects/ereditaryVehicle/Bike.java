package org.generation.italy.examples.Exercises.Exercise1.Objects.ereditaryVehicle;

public class Bike extends Vehicle{
    public boolean hasBody;

    public Bike(String brand, int maxSpeed, boolean hasBody){
        super(brand, maxSpeed);
        isHasBody(hasBody);
    }

    public boolean isHasBody(boolean hasBody) {
        return this.hasBody;
    }

    public void setHasBody(boolean hasBody) {
        if(isHasBody(hasBody)){
            IO.println("ha una carrozzeria");
        }else{
            IO.println("non ha una carrozzaria");
        }
    }

    @Override
    public void describe(){
        IO.println("Questa moto è una " + getBrand() + " " + isHasBody(hasBody)  + ". La sua velocità massima è di " + getMaxSpeed() + " km/h");
    }
}
