package org.generation.italy.examples.oo.asincrone.ereditarietà;

public class ForeignEmployee extends Employee {

    private String nativeLanguage;

    public ForeignEmployee(String name,String surname,String dateOfBirth,String g,String job ,double salary,String nativeLanguage){
        super(name,surname,dateOfBirth,g,job,salary);
        this.nativeLanguage = nativeLanguage;
    }

    @Override
    public String toString() {
        return super.toString() + "ForeignEmployee{" +
                "nativeLanguage='" + nativeLanguage + '\'' +
                '}';
    }
}
