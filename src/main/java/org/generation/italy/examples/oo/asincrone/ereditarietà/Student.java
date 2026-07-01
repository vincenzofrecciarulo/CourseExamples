package org.generation.italy.examples.oo.asincrone.ereditarietà;

public class Student  extends Person {

    protected int year;
    protected String section;

    public Student (String name,String surname,String dateOfBirth,String g,int year,String section){
        super(name,surname,dateOfBirth,g);
        this.year = year;
        this.section = section;
    }


    public int getYear (){
        return year;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection (){
        return section;
    }

    public void setYear (int year){
        this.year = year;
    }

}
