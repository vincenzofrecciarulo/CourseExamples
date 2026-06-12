package org.generation.italy.examples.oo.lambdaandstreams.exercises;

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
    private double salary;
    private LocalDate hiredate;
    private List<String> knownLanguages;
    public static final int SENIOR_YEARS = 10;

    public Coder(String name, String surname, char gender, LocalDate birthdate, double salary, LocalDate hiredate, String... languages) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.salary = salary;
        this.hiredate = hiredate;
        this.knownLanguages = new ArrayList<>(List.of(languages));
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public List<String> getKnownLanguages() {
        return knownLanguages;
    }

    public int getWorkingYears() {
        return (int) ChronoUnit.YEARS.between(hiredate, LocalDate.now());
    }

    public boolean isSenior() {
        return getWorkingYears() >= SENIOR_YEARS;
    }

    public boolean isMale() {
        return gender == 'm';
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    public String getFullName() {
        return name + " " + surname;
    }

    //crea un metodo che prende un parametro di string in input e ritorna true se il programmatore conosce tutti i linguaggi inseriti in input
    public boolean knowsAllLanguages(String... languages) {
//        for (String s : languages) {
//            if (!knownLanguages.contains(s)) { //metodo basic
//                return false;
//            }
//        }
//        return true;
        return Arrays.stream(languages).allMatch(l -> knownLanguages.contains(l)); //posso fare la stessa cosa di un ciclo for con uno stream
    }

    public void addToFemaleSalary() {
    }
}