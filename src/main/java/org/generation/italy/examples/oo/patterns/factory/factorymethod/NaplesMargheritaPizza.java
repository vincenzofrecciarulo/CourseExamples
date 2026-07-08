package org.generation.italy.examples.oo.patterns.factory.factorymethod;

public class NaplesMargheritaPizza implements Pizza {
    @Override
    public String name() {
        return "Margherita";
    }

    @Override
    public String style() {
        return "soft and dramatic Naples";
    }
}
