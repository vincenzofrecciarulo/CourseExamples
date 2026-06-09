package org.generation.italy.examples.oo.abstraction.abstractclasses;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class FullstackDeveloper extends Person{
    private ArrayList<String> languages;
    private LocalDate startedProgramming;

    public FullstackDeveloper(String name, String surname, LocalDate dateofbirth, char gender, LocalDate startedProgramming) {
        super(name, surname,dateofbirth, gender);
        this.languages = new ArrayList<>();
        this.startedProgramming = startedProgramming;
    }

    public int getYearsOfExperience() {
       // return LocalDate.now().getYear() - startedProgramming.getYear();
        return (int)ChronoUnit.YEARS.between(startedProgramming, LocalDate.now());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString() + "\n Ho " + getYearsOfExperience() + " anni di esperienza.\n");
        if (languages.isEmpty()) {
            result.append("\nSono un niubbo e non conosco nessun linguaggio...");
        } else {
            result.append("\nConosco i seguenti linguaggi: ");
            for (String language : languages) {
                result.append("\n").append(language);
            }
        }
        return result.toString();
    }
}
