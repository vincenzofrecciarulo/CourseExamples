package org.generation.italy.examples.chatgpt.stream.exercise4;

import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Student> students = List.of(
                new Student("Matteo", 25),
                new Student("Anna", 17),
                new Student("Luca", 22),
                new Student("Giulia", 16),
                new Student("Marco", 30)
        );

        List<String> adultNames = printAdultStudents(students);
        System.out.println(adultNames);
    }

    public static List<String> printAdultStudents(List<Student> students) {
        return students.stream()
                .filter(student -> student.getAge()>=18)
                .map(student -> student.getName())
                .sorted()
                .toList();
    }
}
