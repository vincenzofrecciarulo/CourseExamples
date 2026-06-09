package org.generation.italy.examples.oo.collections;

import java.time.LocalDate;

public class Cat implements Comparable<Cat>{
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

    public boolean isOlderThan(Cat other){
        return this.dateOfBirth.isBefore(other.dateOfBirth);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return this.weight - o.weight;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getWeight() {
        return weight;
    }
}
