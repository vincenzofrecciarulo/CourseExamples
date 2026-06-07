package org.generation.italy.examplesMio.ooMio.magicMio;

import java.util.Random;

public enum House {

    GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN;

    public static Random luck = new Random();
    public Student[] members;
    public int studentCount;
    public static int perfectDim;

    public void initialize(int numStudents) {
        perfectDim = numStudents / House.values().length;
        boolean hasExtra = numStudents % House.values().length != 0;

        members = new Student[hasExtra ? perfectDim + 1 : perfectDim];
    }

    public boolean ifPerfectlyFull() {
        return studentCount >= perfectDim;
    }

    public boolean isExtraFull() {
        return studentCount >= members.length;
    }

    public boolean addStudent(Student s, boolean extra) {
        boolean isFull = extra ? isExtraFull() : ifPerfectlyFull();
        if (isFull) {
            return false;
        }
        members[studentCount] = s;
        s.destinationHouse = this;
        studentCount++;
        return true;
    }

 /*   public void reportAssignments() {
        for (int i = 0; i < House.values().length; i++) {
            System.out.printf("%-20s", House.values()[i].name());
        }
        IO.println();
        for (int i = 0; i < GRYFFINDOR.members.length; i++) {
            System.out.printf("%-20s%-20s%-20s%-20s", GRYFFINDOR.members[i].name, HUFFLEPUFF.members[i].name, RAVENCLAW.members[i].name, SLYTHERIN.members[i].name);
        }
    }*/

    public static void reportAssignments() {
        for (int i = 0; i < House.values().length; i++) {
            System.out.printf("%-25s", House.values()[i].name());
        }
        IO.println();

        for (int i = 0; i < GRYFFINDOR.members.length; i++) {
            for (int j = 0; j < House.values().length; j++) {
                String studentName = House.values()[j].members[i].name !=null ? House.values()[j].members[i].name : "Posto vuoto";
                System.out.printf("%-25s", studentName);
            }
            IO.println();
        }

    }

    public void addPrefect(Student prefect) {
        members[0] = prefect;
        prefect.destinationHouse = this;
        studentCount++;
    }

    public static House getRandomAvailableHouse(boolean extra) {
        boolean isFull;
        House destination;

        do {
            int random = luck.nextInt(House.values().length);
            destination = House.values()[random];
            isFull = extra ? destination.isExtraFull() : destination.ifPerfectlyFull();
        } while (isFull);

        return destination;
    }


}
