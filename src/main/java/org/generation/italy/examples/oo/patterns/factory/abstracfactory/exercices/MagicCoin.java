package org.generation.italy.examples.oo.patterns.factory.abstracfactory.exercices;

public class MagicCoin implements Treasure{
    @Override
    public String name() {
        return "Grande Moneta";
    }

    @Override
    public String description() {
        return "è solo bella ma non fa nulla";
    }
}
