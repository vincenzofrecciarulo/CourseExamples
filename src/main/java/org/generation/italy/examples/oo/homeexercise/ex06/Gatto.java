package org.generation.italy.examples.oo.homeexercise.ex06;

public class Gatto extends Animale {

    public Gatto(String name, int age) {
        super(name, age);
    }

    @Override
    public void faiVerso(){
        System.out.println("Miao!");
    }

    public void graffia(){
        System.out.println("Il gatto è arrabbiato!");
    }
}
