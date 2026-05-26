package org.generation.italy.examples.oo.magic;

import java.util.Random;

/*
In Java (a diff. di altri linguaggi), un enum è un po' come una
CLASSE di cui esisteranno solo N OGGETTI FISSI.
Gli enum SONO CLASSI.
Ogni membro di un enum è un OGGETTO.
E' come se questa fosse una classe House di cui NON POSSO
DICHIARARE QUANTI OGGETTI VOGLIO, ma solo quelli che stabilisco
qui.

Essendo una classe, può avere metodi e variabili.
*/
public enum House {
    GRYFFINDOR, SLYTHERIN, HUFFLEPUFF, RAVENCLAW;
    public Student[] members;

    public int studentCount;
    public static int perfectDimension;  // this can be static, cause the value will be the same for every member in the enum!
    public static Random luck = new Random();

    public void initialize(int numStudents) {
        perfectDimension = numStudents / House.values().length;
        boolean hasExtra = numStudents % House.values().length != 0;
        members = new Student[hasExtra ? perfectDimension + 1 : perfectDimension];  // we need this cause arrays are fixed in size. we create it based on numStudents
    }

    public boolean isPerfectlyFull() {
        return studentCount >= perfectDimension;
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
        s.assignedHouse = this;
        studentCount++;   // this could be written in the line above members[studentCount++] = s (post-increment)
        return true;
    }

//    public void reportAssignments() {
//        String name = "Ciccio";
//        System.out.printf("Il nome dello studente e' %s%n", name); // string interpolation - %n: vai a capo %s: placeholder nel template
//        for (int i=0; i < House.values().length; i++) {
//            System.out.println("%-20s", House.values[i].name());
//        }
//        System.out.println();
//        for (int i = 0; i < GRYFFINDOR.members.length; i++) {
//            System.out.printf(
//                    "%-20s%-20s%-20s%-20s",
//                    GRYFFINDOR.members[i].name,
//                    SLYTHERIN.members[i].name,
//                    HUFFLEPUFF.members[i].name,
//                    RAVENCLAW.members[i].name
//                    );
//        }
//    }

    public static void reportAssignments() {
        for (int i=0; i < House.values().length; i++) {
            System.out.printf("%-25s", House.values()[i].name());
        }
        System.out.println();
        for (int i = 0; i < GRYFFINDOR.members.length; i++) {
            for (int j = 0; j < House.values().length; j++) {
                String studentName =
                        House.values()[j].members[i] != null
                                ?
                                House.values()[j].members[i].name
                                :
                                "Posto vuoto";
                System.out.printf("%-25s", studentName);
            }
            System.out.println();
        }
    }

    public void addPrefect(Student prefect) {
        members[0] = prefect;
        prefect.assignedHouse = this;
        studentCount++;
    }

    public static House getRandomAvailableHouse(boolean extra) {
        boolean isFull;
        House destination;
        do {
            int random = luck.nextInt(House.values().length);
            destination = House.values()[random];
            isFull = extra ? destination.isExtraFull() : destination.isPerfectlyFull();
        } while (isFull);
        return destination;
    }
}
