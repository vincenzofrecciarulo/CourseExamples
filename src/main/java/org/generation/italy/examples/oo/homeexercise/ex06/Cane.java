package org.generation.italy.examples.oo.homeexercise.ex06;

public class Cane extends Animale {

    public Cane(String name, int age) {
        super(name, age);
    }

    @Override
    public void faiVerso (){
        System.out.println("Bau!");
    }

    public void portaAPasseggio(){
        System.out.println("Metti il guinzaglio!");
    }
}
