package org.generation.italy.examples.oo.magic;

import java.util.Random;

public enum House {
    GRYFFINDOR, SLYTHERIN, HUFFLEPUFF, RAVENCLAW;

    public Student[] members;
    public int studentCount;
    public static int perfectDim;
    private static final Random luck = new Random();

    public void initialize(int totalStudents) {
        House[] houses = House.values();
        perfectDim = totalStudents / houses.length;
        boolean hasExtra = totalStudents % houses.length != 0;
        members = new Student[hasExtra ? perfectDim + 1 : perfectDim];
    }

    public boolean isPerfectlyFull() {
        return studentCount >= perfectDim;
    }

    public boolean isExtraFull() {
        return studentCount >= members.length;
    }

    public boolean addStudent(Student s, boolean extra) {
        boolean isFull = extra ? isExtraFull() : isPerfectlyFull();
        if (isFull) {
            return false;
        }
        members[studentCount] = s;
        s.destinationHouse = this;
        studentCount++;
        return true;
    }

    public void addPrefect(Student prefect) {
        members[0] = prefect;
        prefect.destinationHouse = this;
        studentCount++;
    }

    public static House getRandomAvailableHouse(boolean extra) {
        House[] houses = House.values();
        House destination;
        boolean isFull;

        do {
            int random = luck.nextInt(houses.length);
            destination = houses[random];
            isFull = extra ? destination.isExtraFull() : destination.isPerfectlyFull();
        } while (isFull);

        return destination;
    }

    public static void reportAssignments() {
        House[] houses = House.values();

        // Stampa le intestazioni delle case
        for (House house : houses) {
            System.out.printf("%-25s", house.name());
        }
        System.out.println();

        // Trova la lunghezza massima dell'array per evitare IndexOutOfBounds
        int maxRows = GRYFFINDOR.members.length;

        // Stampa la tabella degli studenti
        for (int i = 0; i < maxRows; i++) {
            for (House house : houses) {
                String studentName = "Posto vuoto";
                if (i < house.members.length && house.members[i] != null) {
                    studentName = house.members[i].name;
                }
                System.out.printf("%-25s", studentName);
            }
            System.out.println();
        }
    }
}
