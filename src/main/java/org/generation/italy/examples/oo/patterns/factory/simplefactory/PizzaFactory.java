package org.generation.italy.examples.oo.patterns.factory.simplefactory;

public class PizzaFactory {
    private PizzaFactory() {
    }

    public static Pizza createPizza(PizzaType type) {
        return switch (type) {
            case MARGHERITA -> new MargheritaPizza();
            case DIAVOLA -> new DiavolaPizza();
            case PINEAPPLE_REVENGE -> new PineappleRevengePizza();
        };
    }
}
