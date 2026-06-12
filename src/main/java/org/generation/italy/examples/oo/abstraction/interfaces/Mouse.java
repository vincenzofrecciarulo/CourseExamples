package org.generation.italy.examples.oo.abstraction.interfaces;

public class Mouse implements Animal{

        @Override
        public void verse() {
        IO.println("squit");
    }
        @Override
        public void typeFood() {
        IO.println("elephant");
    }
        @Override
        public void lifetime(){
        IO.println("from 1 to 3 years");
    }
        @Override
        public String nameSpecie(){
        String name ="mouse";
        return name;
    }

    }

