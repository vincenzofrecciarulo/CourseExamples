package org.generation.italy.examples.chatgpt.interf;

public class Bird extends Animal implements Flyable{

    @Override
    public void makeSound() {
        System.out.println("UH");
    }

    @Override
    public void fly(){
        System.out.println(name + " vola.");
    }

    @Override
    public void eat(){
        System.out.println(name + " mangia.");

    }
}
