package org.generation.italy.examples.hogwarts;

import java.util.Random;

public class MagicHat {
    // seguiamo qui un approccio procedurale ("senza" oggetti)
    // students sarà un array bidimensionale (una matrice - righe e colonne)
    // righe = numero di studenti; colonne = 2, corrispondenza con uno degli enum (preferenza casa)
    // un array bidimensionale è un array in cui ogni elemento è un array
    final static String[][] students = new String[][] {
            // col primo indice scorriamo nell'array "grande", col secondo in ogni singolo sottoarray
            {"Alice Romero", House.SLYTHERIN.name()},
            {"Daniele Sciarrini", null},  // nessuna preferenza  // "Daniele Sciarrini": [1][0] null: [1][1]
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

    final static boolean EXTRA_STUDENTS = (students.length + prefects.length) > PERFECT_CLASS_SIZE;
    // possiamo avere max 3 studenti "di troppo" (multiplo di 4 ecc)
    final static String[][] houses = new String[House.values().length][EXTRA_STUDENTS ? PERFECT_HOUSE_SIZE + 1 : PERFECT_HOUSE_SIZE];

    final static int[] counters = new int[House.values().length];

    final static Random luck = new Random();

    static void main() throws InterruptedException {  // una main che lanci una Exception è da evitare
        // paradigma procedurale
        shuffleStudents();
        assignPrefects();
        assignStudents();
        assignExtraStudents();
        reportAssignmentsTable();
    }

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

    static void assignPrefects() {
        for (int i = 0; i < prefects.length; i++) {
            String[] prefect = prefects[i];
            String name = prefect[0];
            String houseName = prefect[1];
            // returns an House (enum) instance. valueOf takes a String and we get the corresponding enum value
            House h = House.valueOf(houseName);
            int pos = h.ordinal();        // position of our chosen house in the enum (0-1-2-3)
            houses[pos][0] = name;
            counters[pos]++;           // we increment the corresponding house counter
        }
    }

    static void assignStudents() throws InterruptedException {
        for (int i=0; i<PERFECT_CLASS_SIZE - prefects.length; i++) {    // we already assigned prefects
            String[] student = students[i];
            String studentName = student[0];
            String houseName = student[1];
            House favoriteHouse = null;
            if (houseName != null) {
                favoriteHouse = House.valueOf(houseName);
            }
            IO.println(studentName + "...mmmmmmh...");
//            Thread.sleep(2000 + luck.nextInt(2000));
            if (houseName != null) {
                int favoriteHousePos = favoriteHouse.ordinal();
                boolean hasSpace = counters[favoriteHousePos] < PERFECT_HOUSE_SIZE;
                // we can pause the execution thread. here we do it for 2s+0..2s to simulate suspance
                if (hasSpace) {
                    int chance = luck.nextInt(3); // 0..2
                    if (chance == 0) {   // 1 on 3 possibilities
                        houses[favoriteHousePos][counters[favoriteHousePos]] = studentName;
                        counters[favoriteHousePos]++;
                        IO.println(studentName + " ha avuto culo ed è stato aggiunto alla sua casa preferita!");
                        continue;     // on to the next student
                    }
                }
            }
            // if we get here, either there was no space in the classroom or the student didn't get his favourite house
            int randomPos;
            do {
                randomPos = luck.nextInt(houses.length);
            } while (counters[randomPos] == PERFECT_HOUSE_SIZE);    // till the house is full
            houses[randomPos][counters[randomPos]] = studentName;
            counters[randomPos]++;
            String randomHouseName = House.values()[randomPos].name(); // we get the enum and convert it to String
            IO.println(studentName + " è stato aggiunto casualmente alla casa " + randomHouseName);
            // lazy evaluation - we never risk giving null to randomHouseName.equals
            if (favoriteHouse != null && randomHouseName.equals(favoriteHouse.name())) {
                IO.println("Che botta di culo! Lo studente "
                        + studentName +
                        " e' stato aggiunto casualmente alla sua casa preferita: "
                        + randomHouseName);
            }
        }
    }

    static void assignExtraStudents() {
        for (int i = PERFECT_CLASS_SIZE - prefects.length; i < students.length; i++) {
            int randomPos;
            String[] student = students[i];
            String studentName = student[0];
            House favoriteHouse = House.valueOf(student[1]);
            do {
                randomPos = luck.nextInt(houses.length);
            } while(counters[randomPos] == PERFECT_HOUSE_SIZE + 1);
            houses[randomPos][counters[randomPos]] = studentName;
            counters[randomPos]++;
            String randomHouseName = House.values()[randomPos].name(); // we get the enum and convert it to String
            IO.println(studentName + " è stato aggiunto casualmente alla casa " + randomHouseName);
            if (randomHouseName.equals(favoriteHouse.name())) {
                IO.println("Che botta di culo! Lo studente "
                        + studentName +
                        " e' stato aggiunto casualmente alla sua casa preferita: "
                        + randomHouseName);
            }
        }
    }


    public static void assignToHouse() {
        for (int i=0; i<PERFECT_CLASS_SIZE - prefects.length; i++) {    // we already assigned prefects
            String[] student = students[i];
            String studentName = student[0];
            String houseName = student[1];
            House favoriteHouse = null;
            if (houseName != null) {
                favoriteHouse = House.valueOf(houseName);
            }
            IO.println(studentName + "...mmmmmmh...");
//            Thread.sleep(2000 + luck.nextInt(2000));
            if (houseName != null) {
                int favoriteHousePos = favoriteHouse.ordinal();
                boolean hasSpace = counters[favoriteHousePos] < PERFECT_HOUSE_SIZE;
                // we can pause the execution thread. here we do it for 2s+0..2s to simulate suspance
                if (hasSpace) {
                    int chance = luck.nextInt(3); // 0..2
                    if (chance == 0) {   // 1 on 3 possibilities
                        houses[favoriteHousePos][counters[favoriteHousePos]] = studentName;
                        counters[favoriteHousePos]++;
                        IO.println(studentName + " ha avuto culo ed è stato aggiunto alla sua casa preferita!");
                        continue;     // on to the next student
                    }
                }
            }
            // if we get here, either there was no space in the classroom or the student didn't get his favourite house
            int randomPos;
            do {
                randomPos = luck.nextInt(houses.length);
            } while (counters[randomPos] == PERFECT_HOUSE_SIZE);    // till the house is full
            houses[randomPos][counters[randomPos]] = studentName;
            counters[randomPos]++;
            String randomHouseName = House.values()[randomPos].name(); // we get the enum and convert it to String
            IO.println(studentName + " è stato aggiunto casualmente alla casa " + randomHouseName);
            // lazy evaluation - we never risk giving null to randomHouseName.equals
            if (favoriteHouse != null && randomHouseName.equals(favoriteHouse.name())) {
                IO.println("Che botta di culo! Lo studente "
                        + studentName +
                        " e' stato aggiunto casualmente alla sua casa preferita: "
                        + randomHouseName);
            }
        }
    }

    public static void reportAssignments() {
        for (int i=0; i < houses.length; i++) {
            IO.print(House.values()[i].name() + " ");
            for (int j = 0; j < houses[0].length; j++) {
                IO.print(houses[i][j] + " - ");
            }
            IO.println();
        }
    }

    static void reportAssignmentsTable() {      // possiamo risolvere l'allineamento utilizzando printf
        for (int i=0; i < houses.length; i++) {
            System.out.printf("%-25s", House.values()[i].name());
        }
        IO.println();
        for (int i=0; i < houses[0].length; i++) {
            for (int j=0; j < houses.length; j++) {
                System.out.printf("%-25s", houses[j][i] != null ? houses[j][i] : "-");

            }
            IO.println();
        }
    }
}
