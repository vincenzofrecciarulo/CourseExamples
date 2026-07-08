package org.generation.italy.examples.oo.patterns.factory.factorymethod;

public class MilanDiavolaPizza implements Pizza {
    @Override
    public String name() {
        return "Diavola";
    }

    @Override
    public String style() {
        return "precise business-lunch Milan";
    }
}
