package org.generation.italy.examples.hogwarts;

// LE FINAL SONO NON MODIFICABILI DA JAVA

import java.util.Random;

public class MagicHat {
    final static public String[][] students = new String[][]{            //students sarà un array bidimensionale (una matrice)
            {"Alice Romero", House.SLYTHERIN.name()},
            {"Daniele Sciarrini", null},
            {"Domenico Piano", House.SLYTHERIN.name()},
            {"Myriam", House.HUFFLEPUFF.name()},
            {"Marco Tanigi", House.SLYTHERIN.name()},
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
            {"Jacopo di Maio", House.HUFFLEPUFF.name()},
            {"Adriano Guelfi", null},
            {"Pietro Pinto", null},
            {"Corinne Mihai", null},
            {"Mattia Liguori", null},
    };

    final static public String[][] prefects = new String[][]{
            {"Giuseppe Balducci", House.RAVENCLAW.name()},
            {"Manuel Sechi", House.SLYTHERIN.name()},
            {"Chiara De Santis", House.GRYFFINDOR.name()},
            {"Matteo De Cata", House.HUFFLEPUFF .name()},
    };
    /*  Abbiamo bisogno delle dimensioni di ogni casata, quindi numero di studenti diviso ogni casa non funziona correttamente.
    //  e ad ogni modo / 4 è una bad practice, quindi House.values().length mi serve a dare il numero da dividere, quindi 4.
    */
    final static int PERFECT_HOUSE_SIZE = (students.length + prefects.length) / House.values().length;

    //qui sotto
    final static int PERFECT_CLASS_SIZE = (PERFECT_HOUSE_SIZE) * House.values().length;

    final static boolean EXTRA_STUDENTS = (students.length + prefects.length) != PERFECT_HOUSE_SIZE;

    //      QUESTO è MOLTO IMPORTANTE PER DIVIDERE LE ALTRE PERSONE NELLE CASATE
    final static String[][] houses = new String[House.values().length][EXTRA_STUDENTS ? PERFECT_CLASS_SIZE + 1 : PERFECT_CLASS_SIZE];

    final static int[] counters = new int[House.values().length];

    final static Random luck = new Random();

    public static void assignPrefects()

    static void shuffleStudents(){

        for (int i = 0; i < 100; i++) {

            int p1 = luck.nextInt(students.length);     //  0 - students.length
            int p2;
                                                        //lanciamo random finchè non escono diversi
                                                        //una variabile scritta nelle graffe del do/while non verrà letta
                                                        //in nessun altro posto.
            do {
                p2 = luck.nextInt(students.length);
            } while (p1 == p2);


            String[] temp = students[p1];                  //variabile temporanea, stesso algoritmo ma con array di stringa
            students[p1] = students[p2];
            students[p2] = temp;
        }
    }
}
