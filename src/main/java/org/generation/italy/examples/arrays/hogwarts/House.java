//package org.generation.italy.examples.oo.magic;
//
//public enum House {
//    GRYFFINDOR, SLYTHERIN, HUFFLEPUFF, RAVENCLAW;
//
//    public Student[] members;
//    public int studentCount;
//    public static int perfectDim;
//
//    public void initialize(int numStudents) {
//        perfectDim = numStudents / House.values().length;
//        boolean hasExtra = numStudents % House.values().length != 0;
//        members = new Student[hasExtra ? perfectDim + 1 : perfectDim];
//    }
//
//    public boolean isPerfectlyFull() {
//        return studentCount >= perfectDim;
//    }
//
//    public boolean isExtraFull() {
//        return studentCount >= members.length;
//    }
//
//    public boolean addStudent(Student s, boolean extra) {
//        boolean hasSpace = extra ? isExtraFull() : isPerfectlyFull();
//
//        if (!hasSpace) {
//            return false;
//        }
//
//        members[studentCount] = s;
//        studentCount++;
//        return true;
//    }
//}