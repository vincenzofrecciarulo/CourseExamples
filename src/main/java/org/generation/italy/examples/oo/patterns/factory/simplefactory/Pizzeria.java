package org.generation.italy.examples.oo.patterns.factory.simplefactory;

public class Pizzeria {
    public Pizza orderPizza(PizzaType type) {
        return PizzaFactory.createPizza(type);
    }
}
