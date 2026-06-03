package org.generation.italy.examples.oo.asincrone.ereditarietà;

public class Avvio {

   public static void main(String[] args) {
        Student student1 = new Student("Giorgio","Giallo",
                "19-12-1980","male",1986,"A");
        ForeignEmployee employee1 = new ForeignEmployee("Giggi","Finizio","12-12-2012","male",
                "cantante",12000,"Inglese");

       System.out.println(employee1.toString());
    }

}
