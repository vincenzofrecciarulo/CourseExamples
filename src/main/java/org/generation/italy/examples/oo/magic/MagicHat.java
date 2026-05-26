package org.generation.italy.examples.oo.magic;

import java.util.Random;

public class MagicHat {
    private static final int NUM_SHUFFLES = 100;
    private final Random luck = new Random();

    public Student[] students = new Student[] {
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
            new Student("Pippo", House.HUFFLEPUFF)
    };

    public Student[] prefects = new Student[] {
            new Student("Giuseppe Balducci", House.RAVENCLAW),
            new Student("Manuel Sechi", House.SLYTHERIN),
            new Student("Chiara De Santis", House.GRYFFINDOR),
            new Student("Matteo De Cata", House.HUFFLEPUFF),
    };

    public void startAssignmentCeremony() {
        House[] houses = House.values();
        int totalStudentsCount = students.length + prefects.length;

        // Inizializza le case
        for (House house : houses) {
            house.initialize(totalStudentsCount);
        }

        System.out.println("Benvenuti ad Hogwarts\n");
        shuffleStudents();
        assignPrefects();

        // Calcolo della soglia degli studenti standard
        int standardSlots = (houses.length * House.perfectDim) - prefects.length;

        // Assegnamento standard
        for (int i = 0; i < standardSlots; i++) {
            assignStudent(students[i], false);
        }

        // Assegnamento extra
        for (int i = standardSlots; i < students.length; i++) {
            System.out.println("\n--- Assegnamento extra per " + students[i].name + " ---");
            assignStudent(students[i], true);
        }

        System.out.println("\n=== RESOCONTO ASSEGNAMENTI ===");
        House.reportAssignments();
    }

    public void assignPrefects() {
        for (Student prefect : prefects) {
            if (prefect.favouriteHouse != null) {
                prefect.favouriteHouse.addPrefect(prefect);
                System.out.printf("Il prefetto %s è stato aggiunto alla casa %s con tutti gli onori.%n",
                        prefect.name, prefect.favouriteHouse.name());
            }
        }
        System.out.println();
    }

    public void assignStudent(Student s, boolean extra) {
        int chance = luck.nextInt(3);

        // Se non ha preferenze, viene trattato direttamente come se la scelta fosse casuale
        if (s.favouriteHouse == null) {
            System.out.printf("Caro %s, non hai espresso preferenze.%n", s.name);
            forceRandomAssignment(s, extra);
            return;
        }

        if (chance != 0) {
            // Caso in cui la preferenza viene ignorata per sfortuna
            System.out.printf("Caro %s, la tua preferenza per %s non verrà rispettata.%n", s.name, s.favouriteHouse.name());
            forceRandomAssignment(s, extra);
            if (s.destinationHouse == s.favouriteHouse) {
                System.out.println("Che fortuna! Sei finito comunque nella tua casa preferita!");
            }
        } else {
            // Caso in cui si prova a rispettare la preferenza
            System.out.printf("Caro %s, la tua preferenza per %s verrà valutata se c'è spazio.%n", s.name, s.favouriteHouse.name());
            boolean added = s.favouriteHouse.addStudent(s, extra);

            if (added) {
                System.out.printf("Caro %s, sei stato aggiunto alla tua casa preferita!%n", s.name);
            } else {
                System.out.println("La casa è piena! Procediamo al sorteggio casuale.");
                forceRandomAssignment(s, extra);
            }
        }
    }

    // Sotto-metodo di supporto per evitare di ripetere lo stesso codice di rimpiazzo casuale
    private void forceRandomAssignment(Student s, boolean extra) {
        House destination = House.getRandomAvailableHouse(extra);
        destination.addStudent(s, extra);
        System.out.printf("Caro %s, sei stato assegnato a %s.%n", s.name, s.destinationHouse.name());
    }

    public void shuffleStudents() {
        for (int i = 0; i < NUM_SHUFFLES; i++) {
            int pos1 = luck.nextInt(students.length);
            int pos2;
            do {
                pos2 = luck.nextInt(students.length);
            } while (pos2 == pos1);
            swapStudents(pos1, pos2);
        }
    }

    private void swapStudents(int p1, int p2) {
        Student temp = students[p1];
        students[p1] = students[p2];
        students[p2] = temp;
    }
}
