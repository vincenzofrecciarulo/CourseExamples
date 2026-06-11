package org.generation.italy.examples.oo.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class StudentService {
    private StudentRepository studentRepo = new StudentRepository();
    private static long idGenerator = 4; // since we already filled the HashMap (database "simulation") with 3 students

    public void registerStudent(Student s) throws FileNotFoundException, StudentAlreadyExistsException {
        // qui il servizio svolge le operazioni necessarie per registrare uno studente
        if (s.getId() == 0) {
            s.setId(idGenerator++);   // first we set it, then we increment it
        }
//        boolean wasSaved = studentRepo.addStudent(s); // we're simulating the old way of checking errors, before Exceptions
//        if (!wasSaved) {
//            return false;
//        }
        // ipotizziamo che qui ci sia altra business logic. col controllo di sopra, EVITIAMO di sprecare "esecuzione",
        // e ritorniamo errore al metodo chiamante.
//        return wasSaved;
        Optional<Student> x = studentRepo.findById(92); // demonstrating Optional
        x.ifPresent(student -> IO.println(student.getId()));
//        // same as above
//        if (x.isPresent()) {
//            IO.println(x.get().getId());
//        }


        studentRepo.addStudent(s);
        FileReader fr = new FileReader("nonEsisto.txt"); // FileNotFoundException is checked, we HAVE to catch it
        // immaginiamo mezza tonnellata di business logic successiva
    }

    public void doSomethingWithFileSystem() {
        FileReader fr = null;
        try {
            fr = new FileReader("forseEsisto.txt");
            // opero sul file in qualche modo
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // typically used to free resources we allocated in our try block
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
