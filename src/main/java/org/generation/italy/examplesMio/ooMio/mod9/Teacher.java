package org.generation.italy.examplesMio.ooMio.mod9;

public class Teacher extends Employee{

    private String subject;

    public Teacher(String name, String surname, String dateOfBirth, String gender, int salary, String subject) {
        super(name, surname, dateOfBirth, gender, salary);
        this.subject = subject;
    }

    @Override
    public int getYearlyRetribution() {
        return salary * 13;
    }
}
