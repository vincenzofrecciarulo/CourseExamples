package org.generation.italy.examples.oo.asincrone.ereditarietà;

public class Person {

    protected  String name,surname,dateOfBirth,g;

    public Person (String name,String surname,String dateOfBirth,String g){
        this.setName(name);
        this.setSurname(surname);
        this.setDateOfBirth(dateOfBirth);
        this.setG(g);
    }

    public String getName (){
        return name == null ?"":name;
    }

    public String getSurname (){
        return surname == null ?"":surname;
    }
    public String getDateOfBirth (){
        return dateOfBirth == null ?"":dateOfBirth;
    }

    public String getG (){
        return g == null ?"":g;
    }

    public void setName(String name){
        if(name== null){
            return;
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if(surname== null){
            return;
        }

        this.surname = surname;
    }
    public void setDateOfBirth(String dateOfBirth) {
        if(dateOfBirth== null){
            return;
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setG(String g) {
        if(g== null){
            return;
        }
        this.g = g;
    }


        public String toString(){
        return name+" "+surname+" "+dateOfBirth+" "+g;
    }



}

