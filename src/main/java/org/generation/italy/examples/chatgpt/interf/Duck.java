package org.generation.italy.examples.chatgpt.interf;

public class Duck extends Animal implements Swimmable, Flyable{
    public Duck(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Quack!");
    }

    @Override
    public void swim(){
        System.out.println(name + " nuota.");
    }

    @Override
    public void fly(){
        System.out.println(name + " vola.");
    }
}
