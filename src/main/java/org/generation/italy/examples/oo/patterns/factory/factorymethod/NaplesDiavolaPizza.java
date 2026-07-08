package org.generation.italy.examples.oo.patterns.factory.factorymethod;

public class NaplesDiavolaPizza implements Pizza {
    @Override
    public String name() {
        return "Diavola";
    }

    @Override
    public String style() {
        return "soft and dramatic Naples";
    }
}
