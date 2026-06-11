package org.generation.italy.examples.pokemon.model;

public abstract class HealingItem extends Item {
    protected final int healAmount;

    protected HealingItem(String name, String description, int buyPrice, int healAmount) {
        super(name, description, buyPrice);
        this.healAmount = healAmount;
    }

    @Override
    public boolean use(Pokemon pokemon) {
        if (pokemon.getCurrentHp() >= pokemon.getMaxHp()) {
            System.out.println(pokemon.getName() + "'s HP is already full!");
            return false;
        }
        int before = pokemon.getCurrentHp();
        pokemon.heal(healAmount);
        System.out.printf("%s recovered %d HP! (%d → %d)%n",
                pokemon.getName(), pokemon.getCurrentHp() - before,
                before, pokemon.getCurrentHp());
        return true;
    }

    public int getHealAmount() { return healAmount; }
}