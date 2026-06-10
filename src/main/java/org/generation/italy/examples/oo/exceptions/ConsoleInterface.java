package org.generation.italy.examples.oo.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ConsoleInterface {
    private StudentService service = new StudentService();

    static void main() {                //STACK: main->console.registerStudent()->Stringhe in input etc.->service.registerStudent()->repository.addStudent()
        ConsoleInterface c = new ConsoleInterface();
        try {
            c.registerStudent();        //L'eccezione arriva qui, se non gestisce crasha il programma (termina la main) e la VM stampa il messaggio del throw
        } catch (Exception e) {
            IO.println("Il file necessario per registrare lo studente non esiste");
            IO.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void registerStudent() throws FileNotFoundException {
        String firstname = IO.readln("Dammi il nome dello studente");
        String lastname = IO.readln("Dammi il cognome dello studente");
        String birthDateString = IO.readln("Dammi la data di nascita");
        LocalDate birthDate;
        try {                                               //Eccezione unchecked, ma che conviene gestire in quanto dipende dall'input utente
            birthDate = LocalDate.parse(birthDateString);
        } catch(DateTimeParseException d){
            birthDate = LocalDate.now();                    //Soluzione totalmente arbitraria a scopo d'esempio
        }
        Student s = new Student(0, firstname, lastname, birthDate);
        try {                                   //Faccio al suo interno operazioni che potrebbero lanciare eccezioni (anche se indirettamente, in catena di invocazioni)
            service.registerStudent(s);         //Se il metodo che ha chiamato non gestisce l'exception, arriva direttamente qui
            IO.println("Congratulazioni, hai salvato lo studente.");        //Se linea 35 ha successo, si finisce il blocco di try e si ignora il catch
        } catch (
                StudentAlreadyExistsException e) {                 //Se riga 35 non ha successo, salta nel blocco di catch in cui gestiamo l'eccezione (DOBBIAMO PREVEDERE IL TIPO DI ECCEZIONE)
            IO.println(e.getMessage());
        }
    }
}
