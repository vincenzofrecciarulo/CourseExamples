package org.generation.italy.examples.oo.abstraction;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class FullstackDeveloper extends Person{
    private ArrayList<String> languages;
    private LocalDate startedProgramming;

    public FullstackDeveloper(String name, String surname, LocalDate dateofbirth, char gender, LocalDate startedProgramming) {
        super(name, surname, dateofbirth, gender);
        this.startedProgramming = startedProgramming;
        this.languages = new ArrayList<>();
    }

    public int getYearsOfExperience(){
       //return LocalDate.now().getYear()-startedProgramming.getYear();
       return (int) ChronoUnit.YEARS.between(startedProgramming, LocalDate.now());
    }

    @Override
    public String toString() {StringBuilder result = new StringBuilder(super.toString() +
                ", I have" + getYearsOfExperience() +
                "years of experience\n" +
                "I know this languages=");
        for (String language : languages) result.append(language).append("\n");
        return result.toString();
    }
}
