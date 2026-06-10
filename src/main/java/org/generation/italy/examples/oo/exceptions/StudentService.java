package org.generation.italy.examples.oo.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class StudentService {

    private StudentRepository studentRepo = new StudentRepository();
    private static long idGenerator = 4;
    public void registerStudent(Student s) throws FileNotFoundException {
        if (s.getId() == 0) {
            s.setId(idGenerator++);
        }
        studentRepo.addStudent(s);
        FileReader fr = new FileReader("nonesisto.txt");
    }
}
