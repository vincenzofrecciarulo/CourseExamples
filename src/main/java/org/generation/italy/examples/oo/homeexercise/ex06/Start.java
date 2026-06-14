package org.generation.italy.examples.oo.homeexercise.ex06;

public class Start {
    public static void main(String[] args){
    Cane dog = new Cane("Spank" , 12);
    Gatto cat= new Gatto("Tommy",8);

    System.out.println("Il mio cane si chiama " + dog.getName() + ", ed ha " + dog.getAge() + " " + "anni" );
    dog.faiVerso();
    System.out.println("Il mio gatto si chiama " + cat.getName() + ", ed ha " + cat.getAge() + " " + "anni" );
    cat.faiVerso();


    }
}
