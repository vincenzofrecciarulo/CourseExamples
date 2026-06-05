package org.generation.italy.examples.oo.interfaces;

public class Student implements Human {

    @Override
    public void eat() {
        IO.println("Mi faccio una carbonara.");
    }
    @Override
    public void speak() {
        IO.println("Mi piace parlare di Java.");
    }
    @Override
    public void walk() {
        IO.println("Ogni tanto mi faccio una passeggiata.");
    }
    @Override
    public void workForHours(int workHours) {
        IO.println("Sono uno studente, non ho voglia di lavorare per "+workHours+" ore");
    }

    @Override
    public void startRomanticDate() {
        IO.println("Andiamo dal kebbabbaro");
    }

}
