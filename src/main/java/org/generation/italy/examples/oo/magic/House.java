package org.generation.italy.examples.oo.magic;

public enum House {
    GRYFFINDOR,SLYTHERIN,HUFFLEPUFF,RAVENCLAW;
    public Student[] members;
    public int studentCount;
    public static int perfectDim;
    public Random luck = new Random();

    public void initialize(int numStudents){
        perfectDim = numStudents / House.values().length;
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
        studentCount++;
        return true;
    }

//    public void reportAssignmentNonOptimizated() {
//        for (int i=0; i<House.values().length; i++) {
//        System.out.printf("%-20s", House.values()[i].name()); // prima del valore che vogliamo stampare per dire quanti caratteri riserviamo per la stampa (x allineamento in colonna)
//        }                                                     //- allineamento a sinistra, numero dei caratteri ed s per stringa
//        System.out.println();
//        for (int i=0; i< GRYFFINDOR.members.length; i++) {
//            System.out.printf("%-20s%-20s%-20s%-20s%n",
//                    GRYFFINDOR.members[i].name,
//                    SLYTHERIN.members[i].name,
//                    HUFFLEPUFF.members[i].name,
//                    RAVENCLAW.members[i].name
//                    );
//        }
//    }

    public void reportAssignment() {
        for (int i=0; i<House.values().length; i++) {
            System.out.printf("%-20s", House.values()[i].name()); // prima del valore che vogliamo stampare per dire quanti caratteri riserviamo per la stampa (x allineamento in colonna)
        }                                                     //- allineamento a sinistra, numero dei caratteri ed s per stringa
        System.out.println();
        for (int i=0; i< GRYFFINDOR.members.length; i++) {
            for (int j=0; j<House.values().length; j++) {                   //J itera sulle colonne, le case, I itera sugli studenti, la loro posizione nelle case
            System.out.printf("%-20s,House.values()[j].members[i].name);
            }
        }
    }

    public void addPrefect (Student prefect) {
        members[0] = prefect;
        prefect.destinationHouse = this;
    }

    public House getRandomAvailableHouse(boolean extra){
        House destination = null;
        do {
            int random = Luck.nextInt(House.values().length);
            destination = House.values[random];
            boolean isFull = extra ? isExtraFull() :
        } while ();
    }
}
