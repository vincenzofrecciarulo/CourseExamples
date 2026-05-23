package org.generation.italy.examples.hogwarts;

import java.util.Random;

public class MagicHat {
    final static String[][] students = new String[][] {
            {"Alice Romero", House.SLYTHERIN.name()},
            {"Daniele Sciarrini", null},
            {"Domenico Piano", House.SLYTHERIN.name()},
            {"Myriam Spagnuolo", House.HUFFLEPUFF.name()},
            {"Marco Tamigi", House.SLYTHERIN.name()},
            {"Konrad Cwajna", House.SLYTHERIN.name()},
            {"Francesco Liberati", House.GRYFFINDOR.name()},
            {"Martina Zirattu", House.RAVENCLAW.name()},
            {"Andrea Ferraro", House.SLYTHERIN.name()},
            {"Vincenzo Romano", House.RAVENCLAW.name()},
            {"Marina Maresca", House.RAVENCLAW.name()},
            {"Wen Jun Zheng", House.HUFFLEPUFF.name()},
            {"Luca Salazar", House.SLYTHERIN.name()},
            {"Giuseppe Tagliavento", House.SLYTHERIN.name()},
            {"Simone Bergero", House.RAVENCLAW.name()},
            {"Vincenzo Frecciarulo", House.RAVENCLAW.name()},
            {"Matilde Fossi", House.GRYFFINDOR.name()},
            {"Alessandro di Napoli", House.HUFFLEPUFF.name()},
            {"Jacopo De Maio", House.HUFFLEPUFF.name()},
            {"Adriano Guelfi", null},
            {"Pietro Pinto", null},
            {"Corinne Mihai", null},
            {"Mattia Liguori", null},
            {"Andrea Bruno", House.GRYFFINDOR.name()},
            {"Andrea Bruno2", House.GRYFFINDOR.name()},
    };

    final static String[][] prefects = new String[][] {
            {"Giuseppe Balducci", House.RAVENCLAW.name()},
            {"Manuel Sechi", House.SLYTHERIN.name()},
            {"Chiara De Santis", House.GRYFFINDOR.name()},
            {"Matteo De Cata", House.HUFFLEPUFF.name()}
    };

    final static int PERFECT_HOUSE_SIZE = (students.length + prefects.length) / House.values().length;
    final static int PERFECT_CLASS_SIZE = PERFECT_HOUSE_SIZE * House.values().length;
    final static boolean EXTRA_STUDENTS = (students.length + prefects.length) > PERFECT_CLASS_SIZE;
    final static String[][] houses = new String[House.values().length][EXTRA_STUDENTS ? PERFECT_HOUSE_SIZE + 1 : PERFECT_HOUSE_SIZE];
    final static int MAX_PER_HOUSE = (students.length + prefects.length + House.values().length - 1) / House.values().length;
    final static int[] counters = new int[House.values().length];
    final static Random luck = new Random();

    static void main() throws InterruptedException {
        shuffleStudents();
        assignPrefects();
        assignStudents();
        reportAssignmentsTable();
    }

    static void shuffleStudents() {
        for (int i = 0; i < 100; i++) {
            int p1 = luck.nextInt(students.length);
            int p2;
            do {
                p2 = luck.nextInt(students.length);
            } while (p1 == p2);

            String[] temp = students[p1];
            students[p1] = students[p2];
            students[p2] = temp;
        }
    }

    static void assignPrefects() {
        for (int i = 0; i < prefects.length; i++) {
            String[] prefect = prefects[i];
            String name = prefect[0];
            String houseName = prefect[1];
            House h = House.valueOf(houseName);
            int pos = h.ordinal();
            houses[pos][0] = name;
            counters[pos]++;
        }
    }

    static void assignStudents() throws InterruptedException {
        for (int i = 0; i < students.length; i++) {
            String[] student = students[i];
            String studentName = student[0];
            String houseName = student[1];
            House favoriteHouse = null;
            if (houseName != null) {
                favoriteHouse = House.valueOf(houseName);
            }
            IO.println(studentName + "...mmmmmmh...");
            if (houseName != null) {
                int favoriteHousePos = favoriteHouse.ordinal();
                int totaleAssegnati = 0;
                for (int c : counters) totaleAssegnati += c;
                int limiteAttuale = totaleAssegnati < PERFECT_CLASS_SIZE ? PERFECT_HOUSE_SIZE : MAX_PER_HOUSE;
                boolean hasSpace = counters[favoriteHousePos] < limiteAttuale;
                if (hasSpace) {
                    int chance = luck.nextInt(3);
                    if (chance == 0) {
                        houses[favoriteHousePos][counters[favoriteHousePos]] = studentName;
                        counters[favoriteHousePos]++;
                        IO.println(studentName + " ha avuto culo ed è stato aggiunto alla sua casa preferita!");
                        continue;
                    }
                }
            }

            int totaleAssegnati = 0;
            for (int c : counters) totaleAssegnati += c;
            int limiteAttuale = totaleAssegnati < PERFECT_CLASS_SIZE ? PERFECT_HOUSE_SIZE : MAX_PER_HOUSE;

            int randomPos;
            do {
                randomPos = luck.nextInt(houses.length);
            } while (counters[randomPos] == limiteAttuale);
            houses[randomPos][counters[randomPos]] = studentName;
            counters[randomPos]++;
            String randomHouseName = House.values()[randomPos].name();
            IO.println(studentName + " è stato aggiunto casualmente alla casa " + randomHouseName);
            if (favoriteHouse != null && randomHouseName.equals(favoriteHouse.name())) {
                IO.println("Che botta di culo! Lo studente "
                        + studentName +
                        " e' stato aggiunto casualmente alla sua casa preferita: "
                        + randomHouseName);
            }
        }
    }

    public static void reportAssignments() {
        for (int i = 0; i < houses.length; i++) {
            IO.print(House.values()[i].name() + " ");
            for (int j = 0; j < houses[0].length; j++) {
                IO.print(houses[i][j] + " - ");
            }
            IO.println();
        }
    }

    static void reportAssignmentsTable() {
        int maxStudents = 0;
        for (int c : counters) {
            if (c > maxStudents) maxStudents = c;
        }
        for (int i = 0; i < houses.length; i++) {
            System.out.printf(House.values()[i].name() + "\t");
        }
        IO.println();
        for (int j = 0; j < maxStudents; j++) {
            for (int i = 0; i < houses.length; i++) {
                System.out.printf(houses[i][j] + "\t");
            }
            IO.println();
        }
    }
}