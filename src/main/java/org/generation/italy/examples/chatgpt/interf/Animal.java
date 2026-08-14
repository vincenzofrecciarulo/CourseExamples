package org.generation.italy.examples.chatgpt.interf;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public abstract void eat();
}
