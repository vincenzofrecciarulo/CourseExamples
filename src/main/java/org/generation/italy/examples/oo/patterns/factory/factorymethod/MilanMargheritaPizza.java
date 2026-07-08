package org.generation.italy.examples.oo.patterns.factory.factorymethod;

public class MilanMargheritaPizza implements Pizza {
    @Override
    public String name() {
        return "Margherita";
    }

    @Override
    public String style() {
        return "precise business-lunch Milan";
    }
}
