package org.generation.italy.examples.oo.exceptions;

public class StudentService {
    private StudentRepository studentRepo = new StudentRepository();
    private static long idGenerator = 4;
    public void registerStudent(Student s){
        //Qui il servizio fa delle operazioni necessarie prima di registrare uno studente
        if (s.getId()==0) {
            s.setId(idGenerator++);
        }
        studentRepo.addStudent(s);   //Aggiunge lo studente, se gli torna un eccezione e non fa nulla, la funzione si blocca qui

        // Mezza tonnellata di business logic successiva al salvataggio di Student

    }
}
