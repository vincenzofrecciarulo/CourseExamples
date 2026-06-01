package org.generation.italy.examples.modulo8;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private String dateOfBirth;

    public Person(String name, String surname, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // qui sovrascriviamo il metodo toString presente nella classe Object
    @Override
    public String toString(){
        // return name + " " + surname + " " + dateOfBirth;
        return getName() + " " + getSurname() + " " + getDateOfBirth();
    }

    // prima di fare l'override su equals, scriviamo l'hash-code come dal video del modulo 8
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth);
    }

    @Override
    public boolean equals(Object obj) {
        // ora stabiliamo se this e obj sono la stessa cosa e se così allora sono uguali
        if (this == obj){
            return true;
        }

        // se l'oggetto è nullo
        if (obj == null){
            return false;
        }

        // se this è di classe Person e l'oggetto non lo è, allora non sono la stessa cosa
        if (this.getClass() != obj.getClass()){
            return false;
        }

        // qui invece vedo l'oggetto come una Person
        Person person = (Person) obj;

        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(dateOfBirth, person.dateOfBirth);
    }
}