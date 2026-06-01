package org.generation.italy.examples.modulo8;

public class Main {
    public static void main (){
        // Person p = new Person();
        // Student s = new Student();

        // qui utiliziamo il polimorfismo con istanceof (così come è presente nel modulo 8)
        Person p1 = new Student(
                "Matteo",
                "De Cata",
                "22/04/1999",
                2026,
                "JAVITA157");

        if(p1 instanceof Student){
            Student s = (Student) p1;
            IO.println(
                    s.getName() + " "
                    + s.getSurname() + " "
                    + s.getDateOfBirth() + " "
                    + s.getYear() + " "
                    + s.getSection());
        }

        // qui utiliziamo il polimorfismo con l'up-casting (visto a lezione)
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
        IO.println(
                p2.getName() + " "
                + p2.getSurname() + " "
                + p2.getDateOfBirth() + " "
                + ((ForeignEmployee)p2).getNativeLanguage() + " "
                + ((ForeignEmployee)p2).getCompany() + " "
                + ((ForeignEmployee)p2).getSalary());

        // metodo 3 con il "toString"
        IO.println(p2.toString());

        IO.println("\n");

        // Ora creiamo due oggetti di tipo Employee nel main.
        // Hanno lo stesso contenuto e sono in due variabili di nome a e b.
        // Infine confrontiamo se sono uguali.
        ForeignEmployee a = new ForeignEmployee(
                "Michael",
                "Jordan",
                "1963",
                "American",
                "Nike",
                100000);

        ForeignEmployee b = new ForeignEmployee(
                "Michael",
                "Jordan",
                "1963",
                "American",
                "Nike",
                100000);

        IO.println("L'impiegato a è uguale all'impiegato b: " + (a.equals(b)));
    }
}