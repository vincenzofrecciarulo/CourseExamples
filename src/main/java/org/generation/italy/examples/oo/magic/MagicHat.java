package org.generation.italy.examples.oo.magic;

import java.util.Random;

public class MagicHat {
    final static int NUM_SHUFFLES = 100;
    public Random luck = new Random();
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

     public void startAssignmentCeremony(){
         for (int i = 0; i < House.values().length; i++){
             House.values()[i].initialize(students.length + prefects.length);
         }
         IO.println("Benvenuti ad Hogwarts");
         shuffleStudent();
         assignPrefect();
         for (int i = 0; i < House.values().length * House.perfectDim - prefects.length; i++){
             assignStudent(students[i], false);
         }
         for (int i = House.values().length * House.perfectDim - prefects.length; i < students.length; i++){
             System.out.println("Assegnamento extra " + students[i].name);
             assignStudent(students[i], true);
         }
         House.reportAssignments();
     }

     public void assignPrefect(){
         for (int i = 0; i < prefects.length; i ++){
             prefects[i].favouriteHouse.addPrefect(prefects[i]);
             System.out.printf("il prefetto %s , è stato aggiunto con tutti gli onori alla casa %s%n",
                     prefects[i].name,
                     prefects[i].favouriteHouse);
         }
     }

     public void assignStudent(Student s, boolean extra){
         int chance = luck.nextInt(3);
         if (chance != 0) {
             System.out.printf("caro %s , la tua preferenza per %s non verrà rispettata%n", s.name, s.favouriteHouse);
             House destination = House.getRandomAvailableHouse(extra);
             destination.addStudent(s,extra);
             System.out.printf("caro %s , sei stato assegnato a %s%n", s.name, s.destinationHouse);
             if (destination == s.favouriteHouse){
                 System.out.printf("che botta di culo sei finito comunque nella tua casa preferita%n");
             }
         } else {
             System.out.printf("caro %s , la tua preferenza verrà rispettata se la tua casata ha ancora spazio%n", s.name);
             boolean added = s.favouriteHouse != null && s.favouriteHouse.addStudent(s, extra);
             if (added) {
                 System.out.printf("caro %s , sei stato aggiunto alla tua casa preferita", s.name);
             } else {
                 House destination = House.getRandomAvailableHouse(extra);
                 destination.addStudent(s,extra);
                 System.out.printf("caro %s , sei stato assegnato a %s%n", s.name , s.destinationHouse);
             }
         }

     }

     public void shuffleStudent(){
         for (int i = 0; i < NUM_SHUFFLES; i++){
            int pos1 = luck.nextInt(students.length);
            int pos2;
            do {
                pos2 = luck.nextInt(students.length);
            } while(pos2 == pos1);
            swapStudents(pos1,pos2);
         }
     }

     public void swapStudents(int p1, int p2){
         Student temp = students[p1];
         students[p1] = students[p2];
         students[p2] = temp;
     }

}
