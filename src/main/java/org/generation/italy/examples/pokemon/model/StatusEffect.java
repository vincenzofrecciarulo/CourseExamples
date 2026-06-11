package org.generation.italy.examples.pokemon.model;

public enum StatusEffect {
    NONE("---"),
    BURN("BRN"),
    PARALYSIS("PAR"),
    SLEEP("SLP"),
    POISON("PSN");

    private final String label;

    StatusEffect(String label) { this.label = label; }

    public String getLabel() { return label; }
}