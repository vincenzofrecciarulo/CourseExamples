package org.generation.italy.examples.oo.patterns.factory.abstracfactory;

public class SicilianFoodFactory implements ItalianFoodFactory {
    @Override
    public Pizza createPizza() {
        return new SfincionePizza();
    }

    @Override
    public Pasta createPasta() {
        return new PastaAllaNorma();
    }

    @Override
    public Arancino createArancino() {
        return new RaguArancino();
    }
}
