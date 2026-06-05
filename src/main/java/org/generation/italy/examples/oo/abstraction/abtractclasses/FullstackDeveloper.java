package org.generation.italy.examples.oo.abstraction.abtractclasses;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class FullstackDeveloper extends Person {
    private ArrayList<String> languages;
    private LocalDate startedProgramming;

    public FullstackDeveloper(String name, String surname, LocalDate dateofbirth, char gender,
                              LocalDate startedProgramming, String... codingLanguages)  // varargs param NEEDS to be the last
    {
        super(name, surname, dateofbirth, gender);
        this.startedProgramming = startedProgramming;
        this.languages = new ArrayList<>();
        Collections.addAll(languages, codingLanguages);
    }

    public int getYearsOfExperience() {
//        return LocalDate.now().getYear() - startedProgramming.getYear();
        return (int)ChronoUnit.YEARS.between(startedProgramming, LocalDate.now());  // between returns long
    }

    @Override
    public void startWorking() {
        IO.println("Un po' scrivo codice, un po' scrollo su TikTok... ");
    }

    @Override
    public void assignTask() {
        IO.println("Ignoro le direttive del manager e implemento quello che mi pare! ");
    }

    @Override
    public String toString() {
        // string concatenation means creating new strings everytime.
        // StringBuilder is always the same object, more efficient
        StringBuilder result = new StringBuilder(super.toString() + "\nHo " + getYearsOfExperience() + " anni di esperienza.");
        if (languages.isEmpty()) {
            result.append("\nSono un niubbo e non conosco nessun linguaggio... ");
        } else {
            result.append("\nConosco i seguenti linguaggi: ");
            for (String language : languages) {
                result.append("\n").append(language);
            }
        }
        return result.toString();
    }


}
