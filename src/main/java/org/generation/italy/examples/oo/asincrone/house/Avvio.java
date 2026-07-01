package org.generation.italy.examples.oo.asincrone.house;

import org.generation.italy.examples.oo.asincrone.ereditarietà.Person;

public class Avvio {
    public static void main (String[] args){

        House house1 = new House("Via Verdi ,Cassano",100,1000);

        System.out.println(house1.toString());

        Person p1 = new Person("Andrea","Ferraro","17-05-1997","male");

        String name = p1.getName();
        System.out.printf("Il nome è %s ",name);


    }

}
