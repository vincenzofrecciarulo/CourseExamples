package org.generation.italy.examples.oo.abstraction.interfaces;

public class Elephant implements Animal {
    @Override
    public void verse() {
        IO.println("unkown");
    }
    @Override
    public void typeFood() {
        IO.println("dog");
    }
    @Override
    public void lifetime(){
        IO.println("from 20 to 80 years");
    }
    @Override
    public String nameSpecie(){
        String name ="elephant";
        return name;
    }

}
