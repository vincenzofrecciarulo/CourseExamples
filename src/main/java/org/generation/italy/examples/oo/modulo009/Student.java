package org.generation.italy.examples.oo.modulo009;

import java.time.LocalDate;

public class Student extends Person{

    protected int studentVotes;
    protected boolean studentBonus = false;
    protected int cost = 2000;

    public Student(String name, String surname, LocalDate dateOfBirth, char gender, int studentVotes, boolean studentBonus, int cost) {
        super(name, surname, dateOfBirth, gender);
        this.studentVotes = studentVotes;
        this.studentBonus = studentBonus;
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost+studentBonus;
    }


}
