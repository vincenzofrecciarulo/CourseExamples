package org.generation.italy.examples.oo.exercise28;
/*Via Verdi 100, Cassano
Area: 100 MQ
Prezzo al MQ: 1000*/
public class Main {
    static void main() {

        House house1=new House();
        house1.address="Via Verdi 100, Cassano";
        house1.area=100;
        house1.spm=1000;

        IO.println(house1.toString());



    }
}
