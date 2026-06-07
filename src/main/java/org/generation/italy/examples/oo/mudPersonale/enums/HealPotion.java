package org.generation.italy.examples.oo.mudPersonale.enums;

public enum HealPotion {
    SMALL("Pozione di cura", 20, 5, 10.0),
    MEDIUM("Pozione di cura potente", 50, 10, 15.0),
    LARGE("Ultra pozione di cura", 100, 25, 25);

    private final String name;
    private final int healAmount;
    private final int price;
    private final double weight;

    HealPotion(String name, int healAmount, int price, double weight) {
        this.name=name;
        this.healAmount=healAmount;
        this.price=price;
        this.weight=weight;
    }

    public String getName() {
        return name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}
