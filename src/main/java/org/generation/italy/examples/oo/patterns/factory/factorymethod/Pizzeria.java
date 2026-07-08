package org.generation.italy.examples.oo.patterns.factory.factorymethod;

public abstract class Pizzeria {
    public Pizza orderPizza(PizzaType type) {
        Pizza pizza = createPizza(type);
        bake(pizza);
        return pizza;
    }

    protected abstract Pizza createPizza(PizzaType type);

    private void bake(Pizza pizza) {
        IO.println("Baking " + pizza.name() + " | " + pizza.style());
    }
}
