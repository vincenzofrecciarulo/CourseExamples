package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;

public abstract class Employee extends Person{
    protected int cost;


    protected Employee (String name, String surname, LocalDate dateOfBirth, char gender,int cost) {
        super(name,surname,dateOfBirth,gender);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return (cost*12)*2;
    }
}
