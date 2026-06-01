package org.generation.italy.examples.modulo8;

import java.util.Objects;

public class ForeignEmployee extends Person{
    private String nativeLanguage;
    private String company;
    private double salary;

    public ForeignEmployee(String name, String surname, String dateOfBirth, String nativeLanguage, String company, double salary) {
        super(name, surname, dateOfBirth);
        this.nativeLanguage = nativeLanguage;
        this.company = company;
        this.salary = salary;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        // return super.toString() + " " + nativeLanguage + " " + company + " " + salary;
        return super.toString() + " " + getNativeLanguage() + " " + getCompany() + " " + getSalary();
    }

    // molto importante
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // Se le proprità della classe Person non sono uguali a quelle dell'oggetto, allora basta così, cioè sono diversi
        if (super.equals(obj) == false) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        ForeignEmployee employee = (ForeignEmployee) obj;

        return Objects.equals(company, employee.company) &&
                salary == employee.salary;
    }
}