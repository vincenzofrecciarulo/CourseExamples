package org.generation.italy.examples.oo.patterns.factory.simplefactory;

public class MargheritaPizza implements Pizza {
    @Override
    public String name() {
        return "Margherita";
    }

    @Override
    public String description() {
        return "Tomato, mozzarella, basil";
    }
}
