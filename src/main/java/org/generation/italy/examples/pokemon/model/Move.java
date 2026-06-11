package org.generation.italy.examples.pokemon.model;

public class Move {
    private final String name;
    private final PokemonType type;
    private final int power;
    private final int accuracy;
    private final int maxPp;
    private int currentPp;
    private final MoveCategory category;
    private final StatusEffect appliesStatus;
    private final int statusChance; // 0-100

    public Move(String name, PokemonType type, int power, int accuracy, int maxPp, MoveCategory category) {
        this(name, type, power, accuracy, maxPp, category, StatusEffect.NONE, 0);
    }

    public Move(String name, PokemonType type, int power, int accuracy, int maxPp,
                MoveCategory category, StatusEffect appliesStatus, int statusChance) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.maxPp = maxPp;
        this.currentPp = maxPp;
        this.category = category;
        this.appliesStatus = appliesStatus;
        this.statusChance = statusChance;
    }

    /** Returns an independent copy so each Pokémon tracks its own PP. */
    public Move copy() {
        Move m = new Move(name, type, power, accuracy, maxPp, category, appliesStatus, statusChance);
        m.currentPp = this.maxPp; // fresh instance always starts at max
        return m;
    }

    public void usePp()     { if (currentPp > 0) currentPp--; }
    public boolean hasPp()  { return currentPp > 0; }
    public void restorePp() { currentPp = maxPp; }

    public String getName()               { return name; }
    public PokemonType getType()          { return type; }
    public int getPower()                 { return power; }
    public int getAccuracy()              { return accuracy; }
    public int getMaxPp()                 { return maxPp; }
    public int getCurrentPp()             { return currentPp; }
    public MoveCategory getCategory()     { return category; }
    public StatusEffect getAppliesStatus(){ return appliesStatus; }
    public int getStatusChance()          { return statusChance; }

    @Override
    public String toString() {
        return String.format("%-16s | %-8s | %-8s | Pow:%3d | Acc:%3d | PP:%2d/%2d",
                name, type, category, power, accuracy, currentPp, maxPp);
    }
}