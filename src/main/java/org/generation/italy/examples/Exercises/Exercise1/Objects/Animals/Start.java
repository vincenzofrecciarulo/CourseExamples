package org.generation.italy.examples.Exercises.Exercise1.Objects.Animals;

import java.util.ArrayList;

public class Start {
    static void main() {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Cow());

        for(Animal a : animals){
            a.sound();
        }
    }
}
