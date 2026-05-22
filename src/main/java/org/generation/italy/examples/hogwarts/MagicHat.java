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
            {"Matteo De Cata", House.HUFFLEPUFF.name()},
    };
    /*  Abbiamo bisogno delle dimensioni di ogni casata, quindi numero di studenti diviso ogni casa non funziona correttamente.
    //  e ad ogni modo / 4 è una bad practice, quindi House.values().length mi serve a dare il numero da dividere, quindi 4.
    */
    final static int PERFECT_HOUSE_SIZE = (students.length + prefects.length) / House.values().length;

    //qui sotto
    final static int PERFECT_CLASS_SIZE = (PERFECT_HOUSE_SIZE) * House.values().length;

    final static boolean EXTRA_STUDENTS = (students.length + prefects.length) != PERFECT_CLASS_SIZE;

    //      QUESTO è MOLTO IMPORTANTE PER DIVIDERE LE ALTRE PERSONE NELLE CASATE
    final static String[][] houses = new String[House.values().length][EXTRA_STUDENTS ? PERFECT_HOUSE_SIZE + 1 : PERFECT_HOUSE_SIZE];

    final static int[] counters = new int[House.values().length];

    final static Random luck = new Random();

    static void main() throws InterruptedException {                //una main che lancia una eccezione è assolutamente da EVITARE
        shuffleStudents();
        assignPrefects();
        assignStudents();
        assignExtraStudents();
        reportAssignments();
    }



    static void assignPrefects() {
        for (int i = 0; i < prefects.length; i++) {
            String[] prefect = prefects[i];
            String name = prefect[0];
            String houseName = prefect[1];
            House h = House.valueOf(houseName);             //  valueOf prende in input una stringa e restituisce il valore della stringa
            int pos = h.ordinal();
            houses[pos][0] = name;
            counters[pos]++;
        }
    }

    static void assignStudents() throws InterruptedException {
        for (int i = 0; i < PERFECT_CLASS_SIZE - prefects.length; i++) {
            String[] student = students[i];
            String studentName = student[0];
            String houseName = student[1];

            House favoriteHouse = null;
            if(houseName != null){
                favoriteHouse = House.valueOf(houseName);
            }

            IO.println(studentName + " .......mmmhhhh..");
            //Thread.sleep(2000 + luck.nextInt(2000));
            if (houseName != null){
                int favoriteHousePos = favoriteHouse.ordinal();

                boolean hasSpace = counters[favoriteHousePos] < PERFECT_HOUSE_SIZE;

                if (hasSpace) {
                    int chance = luck.nextInt(3);
                    if (chance == 0) {
                        houses[favoriteHousePos][counters[favoriteHousePos]] = studentName;
                        counters[favoriteHousePos]++;
                        IO.println(studentName + " ha avuto culo ed è stato/a aggiunto/a alla sua casa preferita");
                        continue;
                    }
                }
            }

            int randomPos;
            do {
                randomPos = luck.nextInt(houses.length);
            } while (counters[randomPos] == PERFECT_HOUSE_SIZE);

            houses[randomPos][counters[randomPos]] = studentName;
            counters[randomPos]++;
            String randomHouseName = House.values()[randomPos].name();
            IO.println(studentName + " è stato/a aggiunto/a casualmente a " + randomHouseName);

            //lazy evaluation: l'operatore && valuta in ordine la prima condizione, e poi la seconda.
            if (favoriteHouse != null && randomHouseName.equals(favoriteHouse.name())) {
                IO.println("Che botta di culo di " + studentName + " ad essere aggiunti alla propria casa preferita!! : "
                        + favoriteHouse.name());
            }
        }
    }

    static void shuffleStudents() {

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

    static void assignExtraStudents() {
        for (int i = PERFECT_CLASS_SIZE - prefects.length; i < students.length; i++) {
            int randomPos;
            String[] student = students[i];
            String studentName = student[0];
            House favoriteHouse = House.valueOf(student[1]);
            do {
                randomPos = luck.nextInt(houses.length);
            } while (counters[randomPos] == PERFECT_HOUSE_SIZE + 1);

            houses[randomPos][counters[randomPos]] = studentName;
            counters[randomPos]++;
            String randomHouseName = House.values()[randomPos].name();
            IO.println(studentName + " è stato/a aggiunto/a casualmente a " + randomHouseName);
            if (randomHouseName.equals(favoriteHouse.name())) {
                IO.println("Che botta di culo di " + studentName + " ad essere aggiunti alla propria casa preferita!! : "
                        + favoriteHouse.name());
            }
        }
    }

    public static void reportAssignments(){
        for(int i = 0; i < houses.length; i++){
            IO.print(House.values()[i].name() + " ");
            for(int j = 0; j < houses[0].length; j++){
                IO.print(houses[i][j] + " ");
            }
            IO.println();
        }
    }
}
