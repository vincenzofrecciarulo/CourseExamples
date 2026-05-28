package org.generation.italy.examples.oo.exercise27;

public class Main {
    static void main() {

        Person p1= new Person("Ciccio","Pasticcio",50,"male");
        Person p2=new Person("Pippo","Pluto",30,"male");

        IO.println(p1.getName()+" "+p2.getSurname());



    }
}
