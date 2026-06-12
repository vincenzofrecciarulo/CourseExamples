package org.generation.italy.examples.oo.lambdaandstreams.excercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coder {
    private String name;
    private String surname;
    private char gender;
    private LocalDate birthdate;
    private LocalDate hiredate;
    private double salary;
    private List<String> languagesKnown;
    public static final int SENIOR_YEARS = 10;


    public Coder(String name, String surname, char gender, LocalDate birthdate, LocalDate hiredate, double salary, String... languages) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
        this.salary = salary;
        this.languagesKnown = new ArrayList<>(List.of(languages));
    }

    public int getWorkingYears(){
        return (int) ChronoUnit.YEARS.between(hiredate, LocalDate.now());
    }

    public boolean knowsAll(String... languages){
        return Arrays.stream(languages).allMatch(c -> languagesKnown.contains(c));
    }

    public boolean isSenior(){
        return getWorkingYears() >= SENIOR_YEARS;
    }

    public boolean isMale(){
        return gender == 'M';
    }

    public boolean isFemale(){
        return gender == 'F';
    }

    public String getFullName(){
        return name + " " + surname;
    }

    public int getAge(){
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    public List<String> getLanguagesKnows(){
        return languagesKnown;
    }



    public double getSalary() {
        return salary;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public char getGender() {
        return gender;
    }
}
