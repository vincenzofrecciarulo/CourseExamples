package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class AlienQueen implements Boss{
    @Override
    public String name() {
        return "AlienQueen";
    }

    @Override
    public String description() {
        return "Tutti si sottomettono a me";
    }
}
