package org.generation.italy.examples.Exercises.Exercise1.Objects.incapsulationExercise1;

public class Student {
    private String name;
    private  String surname;
    private int score;

    public Student(String name, String surname, int score){
        this.name = name;
        this.surname = surname;
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
       if(score >= 0 && score <= 10){
           this.score = score;
       }else{
           IO.println("Voto non valido");
       }
    }
}
