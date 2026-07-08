package org.generation.italy.examples.oo.patterns.factory.simplefactory;

public class PineappleRevengePizza implements Pizza {
    @Override
    public String name() {
        return "Pineapple Revenge";
    }

    @Override
    public String description() {
        return "Pineapple, ham, and a formal apology to Naples";
    }
}
