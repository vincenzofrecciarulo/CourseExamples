package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class Troll implements Boss {
    @Override
    public String name() {
        return "Troll della foresta";
    }

    @Override
    public void speak() {
        IO.println("Il troll dice: 'Grug!'");
    }

    @Override
    public void attack() {
        IO.println("il troll attacca con una grande mazza chiodata!");
    }
}
