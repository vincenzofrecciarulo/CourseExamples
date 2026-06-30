package org.generation.italy.examples.oo.lambdaandstreams.excercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
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
    //crea un metodo che prende un var args di stringhe in input che torna true se li conosce tutti
    public boolean knowsAll(String... languages){
//        for (String s : languages){
//            if (!languagesKnown.contains(s)){
//                return false;
//            }
//        }
//        return true;
         return Arrays.stream(languages).allMatch(l->languagesKnown.contains(l));
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

    public LocalDate getHiredate()   { return hiredate; }
    public String getFullName()      { return name + " " + surname; }
    public double getSalary()        { return salary; }
    public char getGender()          { return gender; }
    public List<String> getLanguagesKnown() {return languagesKnown;}
}
