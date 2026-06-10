package org.generation.italy.examples.oo.exceptions;

import java.io.FileNotFoundException;
import java.time.LocalDate;

public class ConsoleInterface {
    private StudentService service = new StudentService();

    static void main() {
        ConsoleInterface c = new ConsoleInterface();
        c.registerStudent();
    }

    public void registerStudent(){
        String firstname = IO.readln("Dammi il nome dello studente ");
        String lastname = IO.readln("Dammi il cognome dello studente ");
        String birthDateString = IO.readln("Dammi la data di nascita ");
        LocalDate birthDate = LocalDate.parse(birthDateString);
        Student s = new Student(3, firstname, lastname, birthDate);
        try {
            service.registerStudent(s);
            IO.println("Congratulazioni! Hai salvato lo studente.");
        } catch(IllegalArgumentException | FileNotFoundException e) {
            IO.println(e.getMessage());
        }
    }
}

