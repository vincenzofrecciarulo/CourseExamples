package org.generation.italy.examplesMio.collections;

import java.time.LocalDate;

public class Cat implements Comparable<Cat>{
    private String color;
    private String name;
    private LocalDate dateOFBirth;
    private int weight;

    public Cat(int weight, LocalDate dateOFBirth, String name, String color) {
        this.weight = weight;
        this.dateOFBirth = dateOFBirth;
        this.name = name;
        this.color = color;
    }

    public boolean isOlderThan(Cat other){
        return this.dateOFBirth.isBefore(other.dateOFBirth);
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
}
