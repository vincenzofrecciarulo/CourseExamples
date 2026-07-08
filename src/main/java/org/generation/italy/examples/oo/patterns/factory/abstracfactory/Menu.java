package org.generation.italy.examples.oo.patterns.factory.abstracfactory;

public class Menu {
    private final Pizza pizza;
    private final Pasta pasta;
    private final Arancino arancino;

    public Menu(ItalianFoodFactory foodFactory) {
        pizza = foodFactory.createPizza();
        pasta = foodFactory.createPasta();
        arancino = foodFactory.createArancino();
    }

    public String describe() {
        return pizza.name() + " + " + pasta.name() + " + " + arancino.name();
    }

    public Pizza getPizza() { return pizza; }
    public Pasta getPasta() { return pasta; }
    public Arancino getArancino() { return arancino; }
}
