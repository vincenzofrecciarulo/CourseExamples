package org.generation.italy.examples.oo.exceptions;

import java.time.LocalDate;
import java.util.*;

public class StudentRepository {
    // this NEEDS to be static, otherwise we'd create a new map everytime. remember we're "simulating" a db with this.
    // we're storing the data in-memory, but we'll usually work with a db.
    private static Map<Long,Student> students = new HashMap<>();

    // STATIC BLOCK. we need it to simulate our db, otherwise we'd overwrite elements everytime and fk up the HashMap
    static {
        Student s1 = new Student(1, "Giorgio", "Giorgi", LocalDate.of(2001, 8, 1));
        Student s2 = new Student(2, "Franco", "Franchi", LocalDate.of(1998, 7, 2));
        Student s3 = new Student(3, "Antonio", "Antonini", LocalDate.of(1992, 2, 16));

        students.put(s1.getId(), s1);
        students.put(s2.getId(), s2);
        students.put(s3.getId(), s3);
    }

    public Student findById(long id) {
        return students.get(id);
    }

    public List<Student> findAllOrderedByAge() {
        List<Student> all = new ArrayList<>(students.values());
        Collections.sort(all); // natural ordering
        return all;
    }

    public Collection<Student> findAllBornAfter (LocalDate birthDate) {
        Collection<Student> all = new ArrayList<>();
        for (Student s : students.values()) {
            if (s.isBornAfter(birthDate)) {   // we wrote the helper method isBornAfter() instead of doing it here. good practice
                all.add(s);
            }
        }
        return all;
    }

//    public boolean addStudent(Student s) {
//        if (students.containsKey(s.getId())) {
//            return false;
//        }
//        students.put(s.getId(), s);
//        return true;
//    }

    public void addStudent(Student s) throws StudentAlreadyExistsException {
        if (students.containsKey(s.getId())) {
            // this creates a new IllegalArgumentException object, then throws the Exception object.
            // this immediately stops the method execution, and passes the Exception to the caller.
            throw new StudentAlreadyExistsException("Student ID already present in database");
        }
        students.put(s.getId(), s);
    }
}
