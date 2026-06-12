package org.generation.italy.examples.oo.lambdaandstreams.excercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Coder {
    private String name;
    private String surname;
    private double salary;
    private char gender;
    private LocalDate birthdate;
    private LocalDate hiredate;
    private List<String> languagesKnown;
    public static final int SENIOR_YEARS = 10;

    public Coder(String name, String surname, double salary, char gender, LocalDate birthdate, LocalDate hiredate, String... languages) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.gender = gender;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
        this.languagesKnown = new ArrayList<>(List.of(languages));
    }

    public int getWorkingYears(){
        return (int) ChronoUnit.YEARS.between(hiredate, LocalDate.now());
    }
    public boolean isSenior(){
        return getWorkingYears()>=SENIOR_YEARS;
    }
    public boolean isMale(){
        return gender=='m';
    }
    public int getAge(){
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    public double getSalary()        {return salary;}
    public char getGender()          {return gender;}

}
