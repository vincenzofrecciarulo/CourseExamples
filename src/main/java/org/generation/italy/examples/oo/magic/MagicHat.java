package org.generation.italy.examples.oo.magic;

import java.util.Random;

public class MagicHat {

    final static int NUM_SHUFFLES = 100;
    public Random luck = new Random();

    public Student[] students = {
            new Student("Alice Romero", House.SLYTHERIN),
            new Student("Daniele Sciarrini", null),
            new Student("Domenico Piano", House.SLYTHERIN),
            new Student("Myriam Spagnuolo", House.HUFFLEPUFF),
            new Student("Marco Tamigi", House.SLYTHERIN),
            new Student("Konrad Cwajna", House.SLYTHERIN),
            new Student("Francesco Liberati", House.GRYFFINDOR),
            new Student("Martina Zirattu", House.RAVENCLAW),
            new Student("Andrea Ferraro", House.SLYTHERIN),
            new Student("Vincenzo Romano", House.RAVENCLAW),
            new Student("Marina Maresca", House.RAVENCLAW),
            new Student("Wen Jun Zheng", House.HUFFLEPUFF),
            new Student("Luca Salazar", House.SLYTHERIN),
            new Student("Giuseppe Tagliavento", House.SLYTHERIN),
            new Student("Simone Bergero", House.RAVENCLAW),
            new Student("Vincenzo Frecciarulo", House.RAVENCLAW),
            new Student("Matilde Fossi", House.GRYFFINDOR),
            new Student("Alessandro di Napoli", House.HUFFLEPUFF),
            new Student("Jacopo De Maio", House.HUFFLEPUFF),
            new Student("Adriano Guelfi", null),
            new Student("Pietro Pinto", null),
            new Student("Corinne Mihai", null),
            new Student("Mattia Liguori", null),
            new Student("Andrea Bruno", House.GRYFFINDOR),
            new Student("DUMMY", House.GRYFFINDOR),
    };

    public Student[] prefects = {
            new Student("Giuseppe Balducci", House.RAVENCLAW),
            new Student("Manuel Sechi", House.SLYTHERIN),
            new Student("Chiara De Santis", House.GRYFFINDOR),
            new Student("Matteo De Cata", House.HUFFLEPUFF),
    };

    public void startAssignmentCeremony() {
        for (int i=0; i < House.values().length; i++) {   // initializing houses
            House.values()[i].initialize(students.length + prefects.length);
        }
        IO.println("Benvenuti ad Hogwarts!");
        shuffleStudents();
        assignPrefects();
        // cycle to fill till perfect number of students (not extra)
        for (int i=0; i < House.values().length * House.perfectDimension - prefects.length; i++) {
            assignStudent(students[i], false);
        }
        // cycle to fill in extra students
        for (int i = House.values().length * House.perfectDimension - prefects.length; i < students.length; i++) {
            System.out.println("Assegnamento extra " + students[i].name);
            assignStudent(students[i], true);
        }
        House.reportAssignments();
    }

    public void assignPrefects() {
        for (int i=0; i < prefects.length; i++) {
            prefects[i].favoriteHouse.addPrefect(prefects[i]);
            System.out.printf(
                    "Il prefetto %s e' stato aggiunto con onore alla casa %s%n",
                    prefects[i].name,
                    prefects[i].favoriteHouse
            );
        }
    }

    public void assignStudent(Student s, boolean extra) {
        int chance = luck.nextInt(3); // 0..2
        if (chance != 0) {
            System.out.printf("Caro %s, la tua preferenza per %s non verra' rispettata.%n", s.name, s.favoriteHouse);
            House destination = House.getRandomAvailableHouse(extra);
            destination.addStudent(s, extra);
            System.out.printf("Caro %s, sei stato assegnato a %s%n", s.name, s.assignedHouse);
            if (destination == s.favoriteHouse) {
                System.out.printf("Che botta di culo! Sei finito casualmente nella tua casa preferita.%n");
            }
        } else {
            System.out.printf("Caro %s, la tua preferenza verra' rispettata se la casa ha ancora spazio.%n", s.name);
            boolean added = s.favoriteHouse != null && s.favoriteHouse.addStudent(s, extra);  // null check always first
            if (added) {
                System.out.printf("Caro %s, sei stato aggiunto alla tua casa preferita", s.name);
            } else {
                House destination = House.getRandomAvailableHouse(extra);
                destination.addStudent(s, extra);
                System.out.printf("Caro %s, sei stato assegnato a %s%n", s.name, s.assignedHouse);
            }
        }
    }

    public void shuffleStudents() {
        for (int i = 0; i < NUM_SHUFFLES; i++) {
            int p1 = luck.nextInt(students.length);
            int p2;
            do {
                p2 = luck.nextInt(students.length);
            } while (p2 == p1);
            swapStudents(p1, p2);
        }
    }

    public void swapStudents(int pos1, int pos2) {
        Student temp = students[pos1];
        students[pos1] = students[pos2];
        students[pos2] = temp;
    }
}
