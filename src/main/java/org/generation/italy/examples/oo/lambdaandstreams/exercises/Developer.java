package org.generation.italy.examples.oo.lambdaandstreams.exercises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Developer {
    private String firstName;
    private String lastName;
    private double salary;
    private String gender;
    private LocalDate birthDate;
    private LocalDate hiringDate;
    private List<String> knownLanguages;
    public static final int SENIORITY_TRESHOLD = 10;

    public Developer(String firstName, String lastName, double salary, String gender,
                     LocalDate birthDate, LocalDate hiringDate, String... knownLanguages) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hiringDate = hiringDate;
        this.knownLanguages = new ArrayList<>(List.of(knownLanguages)); // List.of on its own would create an unmodifiable list
    }

//    public boolean knowsAll(String... languages) {
//        for (String s : languages) {
//            if (!knownLanguages.contains(s)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean knowsAll(String... languages) {
        return Arrays.stream(languages)  // arrays don't implement stream(), so we have to call Arrays.stream()
                .allMatch(l -> knownLanguages.contains(l));
    }

    public int getWorkingYears() {
        return (int)ChronoUnit.YEARS.between(hiringDate, LocalDate.now());
    }

    public int getAge() {
        return (int)ChronoUnit.YEARS.between(LocalDate.now(), getBirthDate());
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isSenior() {
        return getWorkingYears() >= SENIORITY_TRESHOLD;
    }

    public boolean isMale() {
        return getGender().equalsIgnoreCase("m");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public List<String> getKnownLanguages() {
        return knownLanguages;
    }
}
