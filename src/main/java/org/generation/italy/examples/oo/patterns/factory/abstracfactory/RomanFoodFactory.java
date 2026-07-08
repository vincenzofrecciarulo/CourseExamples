package org.generation.italy.examples.oo.patterns.factory.abstracfactory;

public class RomanFoodFactory implements ItalianFoodFactory {
    @Override
    public Pizza createPizza() {
        return new PizzaBianca();
    }

    @Override
    public Pasta createPasta() {
        return new Carbonara();
    }

    @Override
    public Arancino createArancino() {
        return new SuppliDisguisedAsArancino();
    }
}
