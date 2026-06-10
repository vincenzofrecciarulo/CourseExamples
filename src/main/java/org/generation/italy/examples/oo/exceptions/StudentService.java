package org.generation.italy.examples.oo.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class StudentService {
    private StudentRepository studentRepo = new StudentRepository();
    private static long idGenerator = 4;

    public void registerStudent(Student s) throws FileNotFoundException {      //Dichiara la pericolosità nella sua firma così l'invocatore sa che è pericoloso
        //Qui il servizio fa delle operazioni necessarie prima di registrare uno studente
        if (s.getId()==0) {
            s.setId(idGenerator++);
        }
        studentRepo.addStudent(s);                                              //Aggiunge lo studente, se gli torna un eccezione e non fa nulla, la funzione si blocca qui
        FileReader fr = new FileReader("nonesisto.txt");                //Apre un file, siccome può non esistere per colpa dell'ambiente, siamo obbligati a gestire l'eccezione
        // Mezza tonnellata di business logic successiva al salvataggio di Student

    }
}
