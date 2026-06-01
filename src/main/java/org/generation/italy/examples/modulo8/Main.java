package org.generation.italy.examples.modulo8;

public class Main {
    public static void main (String[] args){
        // Person p = new Person();
        // Student s = new Student();

        // qui utiliziamo il polimorfismo con istanceof come nel modulo 8
        Person p1 = new Student("Matteo","De Cata", "22/04/1999", 2026, "JAVITA157");
        if(p1 instanceof Student){
            Student s = (Student) p1;
            IO.println(s.getName() + " "
                    + s.getSurname() + " "
                    + s.getDateOfBirth() + " "
                    + s.getYear() + " "
                    + s.getSection());
        }

        // qui utiliziamo il polimorfismo con l'up-casting
        Person p2 = (Person) new ForeignEmployee(
                "Matteo",
                "De Cata",
                "22/04/1999",
                "Italian",
                "Intesa Sanpaolo",
                30000);

        // metodo 1
        IO.println(p2);

        // metodo 2
        IO.println(p2.getName() + " "
                + p2.getSurname() + " "
                + p2.getDateOfBirth() + " "
                + ((ForeignEmployee)p2).getNativeLanguage() + " "
                + ((ForeignEmployee)p2).getCompany() + " "
                + ((ForeignEmployee)p2).getSalary());

        // metodo 3 con il "toString"
        IO.println(p2.toString());
    }
}