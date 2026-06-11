package org.generation.italy.examples.oo.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ConsoleInterface {
    private StudentService service = new StudentService(); // we instance the service, so the Console can talk to it

//     this broke while demonstrating Exceptions, fix it
//    static void main() { // stack will look like:
//        ConsoleInterface ci = new ConsoleInterface();
//        try {
//            ci.registerStudent();
//        } catch (StudentAlreadyExistsException e ) {
//            IO.println("File for saving student doesn't exist! ");
//            IO.println(e.getMessage());
//            // prints a snapshot of the stack at the moment of the Exception throwing. we should be logging here for production code, not printing the stack trace.
//            // there are many levels of logging. we'll talk about it.
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void registerStudent() throws FileNotFoundException {
        String firstName = IO.readln("Student first name: ");
        String lastName = IO.readln("Student last name: ");
        String birthDateString = IO.readln("Student birth date: ");
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateString); // we enclose it in a try-catch since it can throw an exception
        } catch(DateTimeParseException d) {
            birthDate = LocalDate.now(); // we could write a do-while to prompt again, but we'll give a default value
        }
        Student s = new Student(0, firstName, lastName, birthDate);
//        boolean wasRegistered = service.registerStudent(s);

        try {
            service.registerStudent(s);
            IO.println("Student was successfully registered! ");
        } catch(StudentAlreadyExistsException e) { // syntax for catching more than one Exception
            IO.println("There was an error.");
            IO.println(e.getMessage());
        }


        // here we manage the error, if it's there. this is the method which has the authority to fix the error (in fact it's void and doesnt return)
//        if (!wasRegistered) {
//            IO.println("Student ID already exists. Try again! ");
//        } else {
//            IO.println("Student was successfully registered! ");
//        }
    }
}
