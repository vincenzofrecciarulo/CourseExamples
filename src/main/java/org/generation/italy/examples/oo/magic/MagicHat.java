package org.generation.italy.examples.oo.magic;

public class MagicHat {
    public Student[] students = new Student[] {

            new Student{"Alice Romero", House.SLYTHERIN},
            new Student{"Daniele Sciarrini", null},
            new Student{"Domenico Piano", House.SLYTHERIN},
            new Student {"Myriam Spagnuolo", House.HUFFLEPUFF},
            new Student{"Marco Tamigi", House.SLYTHERIN},
            new Student{"Konrad Cwajna", House.SLYTHERIN},
            new Student{"Francesco Liberati", House.GRYFFINDOR},
            new Student{"Martina Zirattu", House.RAVENCLAW},
            new Student {"Andrea Ferraro", House.SLYTHERIN},
            new Student {"Vincenzo Romano", House.RAVENCLAW},
            new Student{"Marina Maresca", House.RAVENCLAW},
            new Student{"Wen Jun Zheng", House.HUFFLEPUFF},
            new Student{"Luca Salazar", House.SLYTHERIN},
            new Student{"Giuseppe Tagliavento", House.SLYTHERIN},
            new Student{"Simone Bergero", House.RAVENCLAW},
            new Student{"Vincenzo Frecciarulo", House.RAVENCLAW},
            new Student{"Matilde Fossi", House.GRYFFINDOR},
            new Student{"Alessandro di Napoli", House.HUFFLEPUFF},
            new Student{"Jacopo De Maio", House.HUFFLEPUFF},
            new Student{"Adriano Guelfi", null},
            new Student{"Pietro Pinto", null},
            new Student{"Corinne Mihai", null},
            new Student{"Mattia Liguori", null},
            new Student{"Andrea Bruno", House.GRYFFINDOR},
    };


    public Student[] prefects = new Student[] {
            new Student("Giuseppe Balducci", House.RAVENCLAW),
            new Student("Manuel Sechi", House.SLYTHERIN),
            new Student("Chiara De Santis", House.GRYFFINDOR),
            new Student("Matteo De Cata", House.HUFFLEPUFF),
    };

    public void assignPrefect(){
        for (int i=0; i< prefects.length; i++) {
            prefects[i].favouriteHouse.addPrefect(prefect[i]);
        }
    }
    public void assignStudent(Student s, boolean extra) {
        int chance = luck.nextInt(3);
        if (chance != 0) {
            System.out.printf("Caro %s ,la tua preferenza per %s non verrà rispettata%n", s.name, s.favouriteHouse);

        } else {
            System.out.printf("Caro %s , la tua preferenza verrà rispettata se la tua casa ha ancora spazio%n", s.name);
        }
    }

    public void shuffleStudent() {
        for (int i = 0; i<NUM_SHUFFLES; i++) {
            int pos1 = luck.nextInt(students.length);
            int pos2;
            do {
                pos2 = luck.nextInt(students.length);
            } while (pos2 == pos1);
        }
    }

    public void swapStudents(int p1, int p2) {
        Student temp = students[p1];
        students[p1] = students[p2];
        students[p2] = temp;
    }
}
