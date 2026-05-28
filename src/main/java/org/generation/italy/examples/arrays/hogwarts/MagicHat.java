//package org.generation.italy.examples.arrays.hogwarts;
//
//import java.util.Random;
//import java.util.Scanner;
//public class MagicHat {
//    // seguiamo qui un approccio procedurale (senza oggetti)
//    // students sara' in array bidimensionale (una matrice)
//    // righe = numero di studenti; 2 colonne corrispondente al numero degli enum
//    // un array bidimensionale e' un array in cui ogni valore e' un array
//    // final sono delle costanti che non possono essere modificata (riassegnata)
//    final static String[][] students = new String[][] {
//            {"Alice Romero", House.SLYTHERIN.name()},
//            {"Daniele Sciarrini", null}, // nessuna preferenza // daniele sciarrini [1][0]
//            {"Domenico Piano", House.SLYTHERIN.name()},
//            {"Myriam Spagnuolo", House.HUFFLEPUF.name()},
//            {"Marco Tamigi", House.SLYTHERIN.name()},
//            {"Konrad Cwajna", House.SLYTHERIN.name()},
//            {"Francesco Liberati", House.GRYFFINDOR.name()},
//            {"Martina Zirattu", House.RAVECLAW.name()},
//            {"Andrea Ferraro", House.SLYTHERIN.name()},
//            {"Vincenzo Romano", House.RAVECLAW.name()},
//            {"Wen Jun Zheng", House.HUFFLEPUF.name()},
//            {"Luca Salazar", House.SLYTHERIN.name()},
//            {"Giuseppe Tagliavento", House.SLYTHERIN.name()},
//            {"Simone Bergero", House.RAVECLAW.name()},
//            {"Vincenzzo Frecciarulo", House.RAVECLAW.name()},
//            {"Matilde Fossi", House.GRYFFINDOR.name()},
//            {"Alessandro di Napoli", House.HUFFLEPUF.name()},
//            {"Jacopo de Maio", House.HUFFLEPUF.name()},
//            {"Adriano Guelfi", null},
//            {"Pietro Pinto", null},
//            {"Corinne Mihai", null},
//            {"Mattia Liguori", null},
//            {"Andrea bruno", House.GRYFFINDOR.name()},
//    } ;
//    final static String[][] prefects = new String[][] {
//            {"Giuseppe Balducci", House.RAVECLAW.name()}
//            {"Manuel Sechi", House.SLYTHERIN.name()},
//            {"Chiara de Santis", House.HUFFLEPUF.name()},
//            {"Matteo de Cata", House.HUFFLEPUF.name()},
//    };
//    // abbiamo bisogno delle dimensioni per ogni casa
//    // n di studenti / n di case in questo caso funziona solo se n di studenti
//    // e' multiplo diretto di 4
//    // House.values() ritorna un array coi contenuti dell'enum
//    final static int PERFECT_HOUSE_SIZE = (students.length + prefects) / House.values().length;
//
//    //sotto la dimensione di ognuna delle 4 classi se il num di studenti fosse "perfetto" (multiplo di 4)
//    // lenght per gli array e' un metodo all'interno dell'oggetto ad es per le string e' un metodo .legnht()
//
//    final static int PERFECT_CLASS_SIZE = PERFECT_HOUSE_SIZE * House.values().length;
//
//    final static boolean EXTRA_STUDENTS = (students.length != prefects.length) != PERFECT_CLASS_SIZE;
//    // POSSIAMO AVERE MAX 3 STUDENTI "di tropo" (multiplo di 4 ecc)
//    final static String [][] houses = new String[House.values().length][EXTRA_STUDENTS ? PERFECT_HOUSE_SIZE + 1 PERFECT_CLASS_SIZE ];
//
//    static final int[] counters = new int[House.values().length];
//
//    final static Random luck = new Random();
//
//    //shuffleStudents altrimenti i primi in lista sarebbero favoriti nella preference
//    // questo algoritmo in realta' non e' perfettamente omogeneo - ci sono shuffle piu' avanzati e piu' fair
//
//    static void  shufflesStudents(){
//        for(int i= 0; i<100; i++){
//            int p1 = luck.nextInt(students.length);         // 0 - student.lenght -1
//            int p2;
//            do {
//                p2 = luck.nextInt(students.length);
//            } while(p1 == p2);                  // lanciano random finche' non escono diversi
//
//            String[] temp = students[p1];       //variabile temporanea stesso algoritmo tra  per scambiare due elementi ma con array di stringhe
//            students[p1] = students[p2];
//            students[p2] = temp;
//        }
//
//        static void assignPrefects(){
//            for (int i = 0; i < prefects.length; i++){
//                String[] prefect = prefects[i];
//                String[] name = prefect[0];
//                String houseName = prefect[1];
//                House h = House.valueOf(houseName);
//                int pos = h.ordinal();
//                houses[pos][0] = name;
//                counters[pos]++;
//            }
//        }
//
//        static void
//                for (int i=0; 1<prefects.length; i++){
//                    String[] student = students[i];
//                    String studentName = student[0];
//                    String HouseName = student[1];
//                    House favoriteHouse = House.valueOf(HouseName);
//                    int FavoriteHousePos = favoriteHouse.ordinal();qus
//                    boolean hasSpace = counters[];
//                }
//
//    }
//}