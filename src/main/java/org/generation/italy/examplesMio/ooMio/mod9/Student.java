package org.generation.italy.examplesMio.ooMio.mod9;

import java.util.List;

public class Student extends Person{

    private List<Integer> gradesList;

    public Student(String name, String surname, String dateOfBirth, String gender, List<Integer> gradesList) {
        super(name, surname, dateOfBirth, gender);
        this.gradesList = gradesList;
    }

    public double media(){
        int tot = 0;
        for(Integer g : gradesList){
            tot += g;
        }
        return (double) tot / gradesList.size();
    }

    public boolean checkGrades(){
        for(Integer d : gradesList){
            if(d <= 5){
                return false;
            }
        }
        return true;
    }


    @Override
    public int getCost() {
        if(media() > 8 && checkGrades()){
            return 1000;
        }
        return 2000;
    }
}
