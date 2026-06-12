package org.generation.italy.examples.oo.lambaexercise;

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

    //crea un meotodo che restituisce un var args di stringhe in input e ritorna true se il
    //il programmatore conosce tutti i lunguaggi

    public boolean knowsAll(String... languages) {
 //       for (String s : languages){
  //          if (!languagesKnown.contains(s)){
 //               return false;
 //           }
//        }
//        return true;
        return Arrays.stream(languages).allMatch(languagesKnown::contains);
    }

    public double getSalary() {
        return salary;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public boolean isMale() {
        return gender=='m';
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public List<String> getLanguagesKnown() {
        return languagesKnown;
    }

    public int getWorkingYears() {
        return (int)ChronoUnit.YEARS.between(hiredate, LocalDate.now());
    }

    public boolean isSenior() {
        return getWorkingYears()>=SENIOR_YEARS;
    }
}

/* COSE DA FARE X IL WEEKEND:
RIGUARDA TUTTO SULLE LAMBDA + ESERCIZI SU DISCORD
 */
