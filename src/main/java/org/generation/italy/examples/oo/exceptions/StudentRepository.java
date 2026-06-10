package org.generation.italy.examples.oo.exceptions;

import java.time.LocalDate;
import java.util.*;

public class StudentRepository {
    private static Map<Long, Student> students = new HashMap<>();

    static {
        Student s1 = new Student
                (1, "Riccardo","Generation", LocalDate.of(1945,5,8));
        Student s2 = new Student
                (2, "Roberto","Italy", LocalDate.of(1945,9,2));
        Student s3 = new Student
                (3, "Yousuke","Yusimatsu", LocalDate.of(1943,11,21));

        students.put(s1.getId(), s1);
        students.put(s2.getId(), s2);
        students.put(s3.getId(), s3);
    }

    public Student findByID(long id) {
        return students.get(id);
    }

    public List<Student> findAllOrderedByAge() {
        List<Student> all = new ArrayList<>(students.values());
        Collections.sort(all);
        return all;
    }

    public Collection<Student> FindAllBornAfter(LocalDate birthDate) {
        Collection<Student> all = new ArrayList<>();
        for (Student s: students.values()) {
            if (s.isBornAfter(birthDate)) {
                all.add(s);
            }
        }
        return all;
    }

    public void addStudent(Student s) {
        if (students.containsKey(s.getId())) {
            throw new IllegalArgumentException("Lo studente che vuoi inserire ha l'id gia' presente nella base dati");
        }
        students.put(s.getId(), s);

    }
}
