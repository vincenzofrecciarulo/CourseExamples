package org.generation.italy.examples.oo.abstraction.interfaces.examples;

public class Student implements Human{

    @Override
    public void eat() {
        System.out.println("Mi faccio una carbonara");
    }

    @Override
    public void speak() {
        System.out.println("Mi piace parlare di java");
    }

    @Override
    public void walk() {
        System.out.println("Ogni tanto mi faccio una passeggiata");
    }

    @Override
    public void workForHours(int workHours) {
        System.out.println("sono uno studente, non ho nessuna voglia di lavorare per " + workHours + " ore.");
    }
}
