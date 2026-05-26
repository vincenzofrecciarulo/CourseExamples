package org.generation.italy.examples.oo.magic;

public enum House {
    GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN;
    public Student[] members;
    public int studentCount;
    public static int perfectDim;

    public void initialize(int numStudents){
        perfectDim= numStudents/House.values().length;
        boolean hasExtra = numStudents % House.values().length != 0;
        members = new Student[hasExtra ? perfectDim+1 : perfectDim];
    }
    public boolean isPerfectlyFull(){
        return studentCount >= perfectDim;
    }
    public boolean isExtraFull(){
        return studentCount >= members.length;
    }
    public boolean addStudent(Student s, boolean extra){
        boolean isFull = extra ? isExtraFull() : isPerfectlyFull();
        if (isFull) {
            return false;
        }
        members[studentCount] = s;
        studentCount++;
        return true;
    }
    public void reportAssignments(){
        for (int i = 0; i < House.values().length; i++) {
            System.out.printf("%-21s", House.values()[i].name());
        }
        System.out.println();
        for (int i = 0; i < GRYFFINDOR.members.length; i++){
            System.out.printf("%-21s%-21s%-21s%-21s%n",
                    GRYFFINDOR.members[i].name,
                    HUFFLEPUFF.members[i].name,
                    RAVENCLAW.members[i].name,
                    SLYTHERIN.members[i].name);
        }
    }

    public void reportAssignments2(){
        for (int i = 0; i < House.values().length; i++) {
            System.out.printf("%-21s", House.values()[i].name());
        }
        System.out.println();
        for (int i = 0; i < GRYFFINDOR.members.length; i++){
            for (int j = 0; j < House.values().length; j++){
                System.out.printf("%-21s", House.values()[j].members[i]);
            }
        }
    }

    public void addPrefect(Student prefect) {
            members[0]=prefect;
            prefect.destinationHouse = this;
    }

}
