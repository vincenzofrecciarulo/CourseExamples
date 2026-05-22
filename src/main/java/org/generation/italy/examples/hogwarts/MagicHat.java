package org.generation.italy.examples.hogwarts;

import java.util.Random;

public class MagicHat {
    // seguiamo qui un approccio procedurale ("senza" oggetti)
    // students sarà un array bidimensionale (una matrice - righe e colonne)
    // righe = numero di studenti; colonne = 2, corrispondenza con uno degli enum (preferenza casa)
    // un array bidimensionale è un array in cui ogni elemento è un array
    final static String[][] students = new String[][] {
            {"Alice Romero", House.SLYTHERIN.name()},
            {"Daniele Sciarrini", null},  // nessuna preferenza
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
            {"Andrea Bruno", House.GRYFFINDOR.name()}
    };

    final static String[][] prefects = new String[][] {
            {"Giuseppe Balducci", House.RAVENCLAW.name()},
            {"Manuel Sechi", House.SLYTHERIN.name()},
            {"Chiara De Santis", House.GRYFFINDOR.name()},
            {"Matteo De Cata", House.HUFFLEPUFF.name()}
    };

    // abbiamo bisogno delle dimensioni di ogni casa
    // n. di studenti / n. di case in questo caso funziona solo se n. di studenti
    // è multiplo diretto di 4
    // costanti in CAPSLOCK
    // è un caso di "magic number" (il discorso subito sopra), bad practice
    // House.values() ritorna un array coi contenuti dell'enum (qui cmq 4)
    final static int PERFECT_HOUSE_SIZE = (students.length + prefects.length) / House.values().length;

    // la dimensione di ognuna delle 4 classi se il num di studenti fosse "perfetto" (multiplo di 4)
    // length per gli array è un metodo all'interno dell'oggetto, ad es. per le String è un metodo .length()
    final static int PERFECT_CLASS_SIZE = PERFECT_HOUSE_SIZE * House.values().length;

    final static boolean EXTRA_STUDENTS = (students.length + prefects.length) != PERFECT_HOUSE_SIZE;
    // possiamo avere max 3 studenti "di troppo" (multiplo di 4 ecc)
    final static String[][] houses = new String[House.values().length][EXTRA_STUDENTS ? PERFECT_HOUSE_SIZE + 1 : PERFECT_CLASS_SIZE];

    final static int[] counters = new int[House.values().length];

    final static Random luck = new Random();

    // shuffleStudents altrimenti i primi in lista sarebbero favoriti nelle preferenze
    // questo algoritmo in realtà non è perfettamente omogeneo - ci sono shuffle più avanzati e più "fair"
    static void shuffleStudents() {
        for (int i=0; i<100; i++) {
            int p1 = luck.nextInt(students.length);            // 0 - students.length-1
            int p2;
            do {
                p2 = luck.nextInt(students.length);
            } while (p1 == p2);                        // lanciamo random finché non escono diversi

            String[] temp = students[p1];             // variabile temporanea, stesso algoritmo per scambiare due elementi ma con array di stringhe
            students[p1] = students[p2];
            students[p2] = temp;
        }
    }
}
