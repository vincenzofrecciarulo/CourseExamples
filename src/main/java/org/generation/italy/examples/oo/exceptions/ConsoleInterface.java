package org.generation.italy.examples.oo.exceptions;

import java.time.LocalDate;

public class ConsoleInterface {
    private StudentService service = new StudentService();

    static void main() {            //STACK: main->console.registerStudent()->Stringhe in input etc.->service.registerStudent()->repository.addStudent()
        ConsoleInterface c = new ConsoleInterface();
        c.registerStudent();        //L'eccezione arriva qui, se non gestisce crasha il programma (termina la main) e la VM stampa il messaggio del throw
    }

    public void registerStudent(){
        String firstname = IO.readln("Dammi il nome dello studente");
        String lastname = IO.readln("Dammi il cognome dello studente");
        String birthDateString = IO.readln("Dammi la data di nascita");
        LocalDate birthDate = LocalDate.parse(birthDateString);
        Student s = new Student(3, firstname, lastname, birthDate);
        try {                                   //Faccio al suo interno operazioni che potrebbero lanciare eccezioni (anche se indirettamente, in catena di invocazioni)
            service.registerStudent(s);         //Se il metodo che ha chiamato non gestisce l'exception, arriva direttamente qui
            IO.println("Congratulazioni, hai salvato lo studente.");        //Se linea 20 ha successo, si finisce il blocco di try e si ignora il catch
        } catch(IllegalArgumentException e){                                //Se 20 non ha successo, salta nel blocco di catch in cui gestiamo l'eccezione (DOBBIAMO PREVEDERE IL TIPO DI ECCEZIONE)
            IO.println("Mi spiace, ma non siamo riusciti a inserire lo studente.");
            IO.println(e.getMessage());
        }


    }
}
