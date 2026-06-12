package org.generation.italy.examples.oo.abstraction.interfaces;

public class Dog implements Animal
{
    @Override
     public void verse() {
        IO.println("bau");
    }
    @Override
      public void typeFood() {
        IO.println("cat");
    }
    @Override
      public void lifetime(){
            IO.println("from 8 to 16 years");
        }
    @Override
     public String nameSpecie(){
        String name ="dog";
        return name;
    }

}
