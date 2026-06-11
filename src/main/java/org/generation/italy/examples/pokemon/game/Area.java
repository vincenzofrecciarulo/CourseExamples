package org.generation.italy.examples.pokemon.game;

public enum Area {
    PALLET_TOWN("Pallet Town",        false, false, new int[]{},        new int[]{}),
    ROUTE_1(    "Route 1",            true,  false, new int[]{16, 19},  new int[]{60, 100}),
    VIRIDIAN_CITY("Viridian City",    false, true,  new int[]{},        new int[]{}),
    VIRIDIAN_FOREST("Viridian Forest",true,  false, new int[]{10, 16, 25}, new int[]{40, 80, 100}),
    PEWTER_CITY("Pewter City",        false, true,  new int[]{},        new int[]{}),
    MT_MOON(    "Mt. Moon",           true,  false, new int[]{74, 19, 92}, new int[]{40, 70, 100});

    private final String displayName;
    private final boolean wildEncounters;
    private final boolean pokemonCenter;
    private final int[]   encounterNums;       // dex numbers of wild Pokémon
    private final int[]   encounterThresholds; // cumulative % thresholds (last must be 100)

    Area(String displayName, boolean wildEncounters, boolean pokemonCenter,
         int[] encounterNums, int[] encounterThresholds) {
        this.displayName        = displayName;
        this.wildEncounters     = wildEncounters;
        this.pokemonCenter      = pokemonCenter;
        this.encounterNums      = encounterNums;
        this.encounterThresholds = encounterThresholds;
    }

    public String getDisplayName()          { return displayName; }
    public boolean hasWildEncounters()      { return wildEncounters; }
    public boolean hasPokemonCenter()       { return pokemonCenter; }
    public int[]   getEncounterNums()       { return encounterNums; }
    public int[]   getEncounterThresholds() { return encounterThresholds; }

    public Area next() {
        Area[] v = values();
        return ordinal() + 1 < v.length ? v[ordinal() + 1] : this;
    }

    public Area prev() {
        return ordinal() > 0 ? values()[ordinal() - 1] : this;
    }

    /** Returns the wild Pokémon dex number chosen by a random roll 0-99. */
    public int pickEncounterDexNumber() {
        if (!wildEncounters) return -1;
        int roll = (int) (Math.random() * 100);
        for (int i = 0; i < encounterThresholds.length; i++) {
            if (roll < encounterThresholds[i]) return encounterNums[i];
        }
        return encounterNums[encounterNums.length - 1];
    }

    /** Wild Pokémon level range per area. Returns {min, max}. */
    public int[] wildLevelRange() {
        return switch (this) {
            case ROUTE_1         -> new int[]{2,  5};
            case VIRIDIAN_FOREST -> new int[]{3,  7};
            case MT_MOON         -> new int[]{8, 14};
            default              -> new int[]{1,  1};
        };
    }
}