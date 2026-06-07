package org.generation.italy.examplesMio.ooMio.mod9;

public class Support extends Employee{

    private String occupation;

    public Support(String name, String surname, String dateOfBirth, String gender, int salary, String occupation) {
        super(name, surname, dateOfBirth, gender, salary);
        this.occupation = occupation;
    }


    @Override
    public int getYearlyRetribution() {
        return salary * 14;
    }
}
