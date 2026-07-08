package org.generation.italy.examples.oo.patterns.factory.factorymethod;

public class NaplesPizzeria extends Pizzeria {
    @Override
    protected Pizza createPizza(PizzaType type) {
        return switch (type) {
            case MARGHERITA -> new NaplesMargheritaPizza();
            case DIAVOLA -> new NaplesDiavolaPizza();
        };
    }
}
