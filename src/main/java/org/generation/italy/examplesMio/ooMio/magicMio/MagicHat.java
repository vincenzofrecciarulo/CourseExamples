package org.generation.italy.examplesMio.ooMio.magicMio;

import java.util.Random;

public class MagicHat {

    final static int NUM_SHUFFLE = 100;

    public Random luck = new Random();

    public Student[] students = new Student[]{
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
    };

    public Student[] prefects = new Student[]{
            new Student("Giuseppe Balducci", House.RAVENCLAW),
            new Student("Manuel Sechi", House.SLYTHERIN),
            new Student("Chiara De Santis", House.GRYFFINDOR),
            new Student("Matteo De Cata", House.HUFFLEPUFF),
    };


    public void startAssingmentCeremony(){

        for(int i = 0; i < House.values().length;  i++){
            House.values()[i].initialize(students.length + prefects.length);
        }
        IO.println("Benvenuti ad Hogwarts");

        shuffleStudents();
        assignPrefects();
        for(int i = 0; i < House.values().length * House.perfectDim - prefects.length; i++){
            assignStudents(students[i], false);
        }

        for(int i = House.values().length * House.perfectDim; i < students.length; i++){

            assignStudents(students[i], true);
        }

        House.reportAssignments();

    }


    public void assignPrefects() {
        for (int i = 0; i < prefects.length; i++) {
            prefects[i].favoriteHouse.addPrefect(prefects[i]);
            System.out.printf("Il prefetto %s è stato aggiunto con onore alla casata %s", prefects[i], prefects[i].favoriteHouse);
        }
    }

    public void assignStudents(Student s, boolean extra) {
        int chance = luck.nextInt(3);
        if (chance != 0) {
            System.out.printf("Caro %s, la tua preferenza per %s, non verrà rispettata%n", s.name, s.favoriteHouse);
            House destination = House.getRandomAvailableHouse(extra);
            destination.addStudent(s, extra);
            System.out.printf("Sei stato assegnato alla casa: %s", s.destinationHouse);
            if (s.destinationHouse == s.favoriteHouse) {
                System.out.printf("Sei finito comunque dentro la tua casa preferita");
            }
        } else {
            System.out.printf("Caro %s, la tua preferenza per verrà rispettata, se la tua casa ha ancora spazio%n", s.name);
            boolean added = s.favoriteHouse != null && s.favoriteHouse.addStudent(s, extra);

            if(added){
                System.out.printf("Caro %s, sei stato aggiunto alla tua casa preferita%n", s.name);
            } else{
                House destination = House.getRandomAvailableHouse(extra);
                destination.addStudent(s, extra);
                System.out.printf("Sei stato assegnato alla casa: %s%n", s.destinationHouse);
            }

        }
    }

    public void shuffleStudents() {
        for (int i = 0; i < NUM_SHUFFLE; i++) {
            int pos1 = luck.nextInt(students.length);
            int pos2;

            do {
                pos2 = luck.nextInt(students.length);
            } while (pos1 == pos2);

            swapStudents(pos1, pos2);
        }
    }

    public void swapStudents(int p1, int p2) {
        Student temp = students[p1];
        students[p1] = students[p2];
        students[p2] = temp;
    }
}
