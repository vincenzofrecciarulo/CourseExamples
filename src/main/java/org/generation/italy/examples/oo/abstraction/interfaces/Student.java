package org.generation.italy.examples.oo.abstraction.interfaces;

public class Student implements Human{

//    @Override
//    public void eat() {
//        IO.println("Mi faccio una amatriciana");
//    }
    @Override
    public void speak() {
        IO.println("Mi piace parlare di Java");

    }
    @Override
    public void walk() {
        IO.println("Ogni tanto esco a toccare l'erba");
    }

    @Override
    public void workForHours(int workHours) {
        IO.println("sono uno studente non ho nessuna voglia di lavorare per " + workHours + " ore");
    }

    @Override
    public void startRomanticDate() {
        IO.println("andiamo dal kebab");
    }

}
