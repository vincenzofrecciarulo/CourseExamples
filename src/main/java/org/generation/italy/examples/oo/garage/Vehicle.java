package org.generation.italy.examples.oo.garage;

public abstract class Vehicle {
    private final String licensePlate;

    public Vehicle(String licensePlate){
        this.licensePlate = licensePlate;
    }



    @Override
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        Vehicle other = (Vehicle) o;
        return this.licensePlate.equals(other.licensePlate);
    }

    @Override
    public int hashCode(){
        return licensePlate.hashCode();
    }


    public String getLicensePlate(){
        return licensePlate;
    }

    public void turnOffEngine(){
        IO.println("Spengo il motore");
    }
}
