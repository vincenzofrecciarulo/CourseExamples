package org.generation.italy.examples.Exercises.Exercise1.Objects.salary;

public class Programmer extends Employee{
    private double tariff;

    public Programmer(String name, double salary, double tariff){
        super(name, salary);
        this.tariff = tariff;
    }

    public double getTariff(){
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    @Override
    public double calculateSalary(double perHour, int hours){
        if(hours > 25){
            return (perHour * hours) + tariff;
        }else{
            return perHour * hours;
        }
    }

}


