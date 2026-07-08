package org.generation.italy.examples.oo.patterns.factory.simplefactory;

public class DiavolaPizza implements Pizza {
    @Override
    public String name() {
        return "Diavola";
    }

    @Override
    public String description() {
        return "Tomato, mozzarella, spicy salami";
    }
}
