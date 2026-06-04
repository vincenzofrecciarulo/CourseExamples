package org.generation.italy.examples.modulo9;

public class Main {
    public static void main (){
        // Person p = new Person();
        // Student s = new Student();

        // qui utiliziamo il polimorfismo con istanceof (così come è presente nel modulo 8)
        Person student = new Student(
                               "Matteo",
                             "De Cata",
                           "22/04/1999",
                                2026,
                              "JAVITA157",
                              8.5,
                        false
                                      );

        // qui riutiliziamo l'instance of presente nel modulo 8
        if(student instanceof Student){
            Student s = (Student) student;
            IO.println(
                       s.getName() + " "
                     + s.getSurname() + " "
                     + s.getDateOfBirth() + " "
                     + s.getYear() + " "
                     + s.getSection() + " "
                     + s.getAverage() + " "
                     + s.isHasFailingGrades()
            );
        }
        IO.println("Il costo dello studente: " + student.getCost() + "\n");

        // qui utiliziamo il polimorfismo con l'up-casting (visto a lezione)
        Person employee = (Person) new Employee(
                                          "Matteo",
                                        "De Cata",
                                      "22/04/1999",
                                   "Italian",
                                        "Intesa Sanpaolo",
                                          30000
                                                );

        // metodo 1
        IO.println(employee);
        IO.println("Il costo del dipendente: " + employee.getCost());

        /*
        Potevamo stampare l'impiegato anche con questi altri due metodi

        // metodo 2
        IO.println(
                employee.getName() + " "
                        + employee.getSurname() + " "
                        + employee.getDateOfBirth() + " "
                        + ((Employee)employee).getNativeLanguage() + " "
                        + ((Employee)employee).getCompany() + " "
                        + ((Employee)employee).getSalary());

        // metodo 3 con il "toString"
        IO.println(employee.toString());

         */
    }
}