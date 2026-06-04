package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class FullstackDeveloper extends Person {
    private ArrayList<String> languages;
    private LocalDate startedProgramming;

    public FullstackDeveloper(String name, String surname, LocalDate dateofbirth, char gender,
                              LocalDate startedProgramming, String... codingLanguages) {
        super(name, surname, dateofbirth, gender);
        this.startedProgramming = startedProgramming;
        this.languages = new ArrayList<>();
        Collections.addAll(languages, codingLanguages);
    }

    public int getYearsOfExperience() {
       // return LocalDate.now().getYear() - startedProgramming.getYear();
        return (int)ChronoUnit.YEARS.between(startedProgramming, LocalDate.now());
    }

    @Override
    public void startWorking() {
    IO.println("Un p' scrivo codice, un po' scrollo su TikTok");
    }

    @Override
    public void assignTask() {
        IO.println("Ignoro le direttive del Manager e implemento quello che mi pare");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString() + "\nHo " + getYearsOfExperience() + " anni di esperienza.\n");
        if (languages.isEmpty()) {
            result.append("\n Sono un niubbo e non conosco nessun linguaggio...");
        } else {
            result.append("\n Conosco i seguenti linguaggi: ");
            for (String language : languages) {
                result.append("\n").append(language);
            }
        }
        return result.toString();
    }
}
