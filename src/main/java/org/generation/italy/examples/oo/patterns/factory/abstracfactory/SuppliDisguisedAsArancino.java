package org.generation.italy.examples.oo.patterns.factory.abstracfactory;

public class SuppliDisguisedAsArancino implements Arancino {
    @Override
    public String name() {
        return "Suppli pretending to be an arancino";
    }
}
