package org.generation.italy.examples.oo.exceptions;

import java.time.LocalDate;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Ciao sono: " + this.firstName + " " + this.lastName;
    }

    @Override
    public int compareTo(Student o) {

        // anche le localdate hanno il compareTo
        return o.birthDate.compareTo(this.birthDate);
        // return -this.birthDate.compareTo(o.birthDate);
    }

    public boolean isBornAfter(LocalDate birthDate){
        return this.birthDate.isAfter(birthDate);
    }
}
