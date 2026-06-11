package org.generation.italy.examples.pokemon.model;

public class Pokemon extends AbstractPokemon {

    public Pokemon(PokedexEntry entry, int level) {
        super(entry, level);
    }

    /**
     * Levels up the Pokémon: increments level, recalculates stats (keeping HP ratio),
     * then checks for new moves.
     *
     * @return true if the Pokémon can now evolve
     */
    public boolean levelUp() {
        double hpRatio = (double) currentHp / maxHp;
        level++;
        recalculateStats();
        currentHp = Math.max(1, (int) (maxHp * hpRatio));
        learnMovesAtCurrentLevel();
        return entry.canEvolve() && level >= entry.getEvolutionLevel();
    }

    /**
     * Replaces this Pokémon's data with its evolution entry.
     * Stats are recalculated; HP ratio is preserved.
     */
    public void evolve(PokedexEntry evolutionEntry) {
        if (evolutionEntry == null) throw new IllegalArgumentException("evolutionEntry non può essere null");
        double hpRatio = (double) currentHp / maxHp;
        this.entry = evolutionEntry;
        recalculateStats();
        currentHp = Math.max(1, (int) (maxHp * hpRatio));
        learnMovesAtCurrentLevel();
    }

    @Override
    public String getDescription() {
        return String.format("#%03d %s\n%s", entry.getNumber(), entry.getName(), entry.getDescription());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s  Lv.%-3d  HP: %d/%d  [%s]",
                entry.getName(), level, currentHp, maxHp, status.getLabel()));
        for (PokemonType t : entry.getTypes()) sb.append("  ").append(t);
        return sb.toString();
    }
}