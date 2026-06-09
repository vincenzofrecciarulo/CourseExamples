package org.generation.italy.examples.oo.collections;

import java.time.LocalDate;

public class Cat implements Comparable<Cat> {
    // these are fields, better to call em like this
    private String name;
    private String color;
    private LocalDate dateOfBirth;
    private int weight;

    public Cat(String name, String color, LocalDate dateOfBirth, int weight) {
        this.name = name;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Cat o) {  // we override compareTo how we need it
        // we decide we want to sort them by ascending weight
        return this.weight - o.weight;
    }
}
