package org.generation.italy.examples.oo.abstraction.interfaces;

public class Cat implements Animal{
    @Override
     public void verse() {IO.println("miao");}
     @Override
     public void typeFood() {IO.println("mouse");}
    @Override
    public void lifetime() {IO.println("from 13 to 20 years");}
    @Override
    public String nameSpecie() {
        String name = "cat";
        return name;
    }

}



