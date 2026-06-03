package org.generation.italy.examples.NewExercises;

public class ForeignEmployee {

    protected String name;
    protected int year;

    public ForeignEmployee(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return name +" "+ year;
    }

    public static void main (String []args) {

        ForeignEmployee f = new ForeignEmployee("Worker", 1996){

        };

           Employee e = new Employee("Marco", 1998, 2023, 1550, "JJD");
            System.out.println(e.getYearStart());
            e.setYearStart(2024);
        System.out.println(e.getYearStart());

    }
}
