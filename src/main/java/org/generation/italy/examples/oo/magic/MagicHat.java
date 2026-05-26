package org.generation.italy.examples.oo.magic;


import java.util.Random;

public class MagicHat {
    final static int NUM_SHUFFLES = 100;
    final static Random luck = new Random();
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
            new Student("Manuel Sechi", House.SLYTHERIN),
            new Student("Giuseppe Balducci", House.RAVENCLAW),
            new Student("Chiara De Santi", House.GRYFFINDOR),
            new Student("Matteo De Cata", House.HUFFLEPUFF),
    };
    public void assignePrefects(){
            for (int i = 0; i < prefects.length; i++) {
                prefects[i].favouriteHouse.addPrefect(prefects[i]);
            }
        }

    public void assigneStudent(Student s, boolean extra) {
        int chance = luck.nextInt(3);
        if (chance != 0) {
            System.out.printf("Caro %s, la tua preferenza per %s, non verrà rispettata%n", s.name, s.favouriteHouse);

        } else {
            System.out.printf("Caro %s, la tua preferenza sarà rispettata se la tua casa ha ancora spazio%n", s.name);

        }
    }
    public void shuffleStudents() {
        for (int i = 0; i < NUM_SHUFFLES; i++) {
            int pos1 = luck.nextInt(students.length);
            int pos2;
            do {
                pos2 = luck.nextInt(students.length);
            } while (pos1 == pos2);
            swapStudents(pos1, pos2);
        }
    }
    public void swapStudents(int p1, int p2){
        Student temp = students[p1];
        students[p1] = students[p2];
        students[p2] = temp;
    }
}
