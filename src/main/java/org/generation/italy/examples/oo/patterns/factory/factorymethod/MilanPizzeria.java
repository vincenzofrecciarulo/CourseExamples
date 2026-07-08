package org.generation.italy.examples.oo.patterns.factory.factorymethod;

public class MilanPizzeria extends Pizzeria {
    @Override
    protected Pizza createPizza(PizzaType type) {
        return switch (type) {
            case MARGHERITA -> new MilanMargheritaPizza();
            case DIAVOLA -> new MilanDiavolaPizza();
        };
    }
}
