package org.generation.italy.examples.oo.magic;

import java.util.Random;

public enum House {
    GRYFFINDOR,SLYTHERIN,HUFFLEPUFF,RAVENCLAW;
    public Student[] members;
    public int studentCount;
    public static int perfectDim;
    public static Random luck = new Random();

    public void initialize(int numStudents){
        perfectDim = numStudents  / House.values().length;
        boolean hasExtra = numStudents % House.values().length != 0;
        members = new Student[hasExtra ? perfectDim + 1 : perfectDim];
    }

    public boolean isPerfectlyFull(){
        return studentCount >= perfectDim;
    }

    public boolean isExtraFull(){
        return studentCount >= members.length;
    }

    public boolean addStudent(Student s, boolean extra){
        boolean isFull = extra ? isExtraFull() : isPerfectlyFull();
        if(isFull) {
            return false;
        }
        members[studentCount] = s;
        s.destinationHouse = this;
        studentCount++;
        return true;
    }

//    public void reportAssignments(){
//        String name = "Ciccio";
//        System.out.printf("Il nome dello studente è %s%n", name);
//        for (int i = 0; i < House.values().length; i ++){
//            System.out.printf("%-20s", House.values()[i].name());
//        }
//        System.out.println();
//        for (int i = 0; i < GRYFFINDOR.members.length; i++){
//            System.out.printf("%-20s%-20s%-20s%-20s%n",
//                    GRYFFINDOR.members[i].name,
//                    SLYTHERIN.members[i].name,
//                    HUFFLEPUFF.members[i].name,
//                    RAVENCLAW.members[i].name
//                    );
//        }
//    }

    public static void reportAssignments(){
        for (int i = 0; i < House.values().length; i ++){
            System.out.printf("%-25s", House.values()[i].name());
        }
        System.out.println();
        for (int i = 0; i < GRYFFINDOR.members.length; i++){
            for (int j = 0; j < House.values().length; j++){
                String studentName = House.values()[j].members[i] != null ? House.values()[j].members[i].name : "Posto vuoto";
                System.out.printf("%-25s",studentName);
            }
            System.out.println();
        }
    }

    public void addPrefect(Student prefect) {
        members[0] = prefect;
        prefect.destinationHouse = this;
        studentCount++;
    }

    public static House getRandomAvailableHouse(boolean extra){
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
