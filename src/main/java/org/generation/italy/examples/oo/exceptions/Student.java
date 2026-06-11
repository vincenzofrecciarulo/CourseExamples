package org.generation.italy.examples.oo.exceptions;

import java.time.LocalDate;

// we make its natural order by ascending age
public class Student implements Comparable<Student> {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Student(long id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ciao, sono " + firstName + " " + lastName;
    }

    @Override
    public int compareTo(Student o) {
        return o.birthDate.compareTo(this.birthDate); // I think it's better to use getters here, it's not necessary tho
    }

    public boolean isBornAfter(LocalDate date) {
        return this.birthDate.isAfter(date);
    }
}
