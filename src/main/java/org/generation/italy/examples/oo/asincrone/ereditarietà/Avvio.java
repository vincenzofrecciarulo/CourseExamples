package org.generation.italy.examples.oo.asincrone.ereditarietà;

public class Avvio {

   public static void main(String[] args) {
        Student student1 = new Student("Giorgio","Giallo",
                "19-12-1980","male",1986,"A");
        ForeignEmployee employee1 = new ForeignEmployee("Giggi","Finizio","12-12-2012","male",
                "cantante",12000,"Inglese");

       //System.out.println(employee1.toString());

       Employee a = new Employee("Banana","Split","10-10-1020",
               "F","lancia buccie",100);
       Employee b = new Employee("Banana","Split","10-10-1020","F",
               "lancia buccie",100);
       System.out.println(a==b);
       System.out.println(a);
       System.out.println(a.equals(b));
       System.out.println(a.hashCode());
       System.out.println(b.hashCode());
       Employee z = null;
       boolean r = a.equals(z);
       r = a.equals("pippo");
    }



}
