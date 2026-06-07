package org.generation.italy.examplesMio.ooMio.mod9;

public abstract class Person {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String gender;

    public Person(String name, String surname, String dateOfBirth, String gender) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name != null ? name : "UNKNOWN";
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname != null ? surname : "UNKNOWN";
    }

    public void setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth != null ? dateOfBirth : "";
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public String getGender() {
        return gender != null ? gender : "";
    }

    public void setGender(String gender) {
        if (gender != null) {
            this.gender = gender;
        }
    }

    public abstract int getCost();


    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", gender='" + getGender() + '\'' +
                '}';
    }
}
