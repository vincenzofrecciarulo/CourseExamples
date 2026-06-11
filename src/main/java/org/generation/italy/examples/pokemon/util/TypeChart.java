package org.generation.italy.examples.pokemon.util;

import org.generation.italy.examples.pokemon.model.PokemonType;

import java.util.EnumMap;
import java.util.Map;

public class TypeChart {

    private static final Map<PokemonType, Map<PokemonType, Double>> chart = new EnumMap<>(PokemonType.class);

    static {
        // 2x super-effective matchups
        set2x(PokemonType.FIRE,     PokemonType.GRASS, PokemonType.ICE, PokemonType.BUG, PokemonType.STEEL);
        set2x(PokemonType.WATER,    PokemonType.FIRE,  PokemonType.GROUND, PokemonType.ROCK);
        set2x(PokemonType.GRASS,    PokemonType.WATER, PokemonType.GROUND, PokemonType.ROCK);
        set2x(PokemonType.ELECTRIC, PokemonType.WATER, PokemonType.FLYING);
        set2x(PokemonType.ICE,      PokemonType.GRASS, PokemonType.GROUND, PokemonType.FLYING, PokemonType.DRAGON);
        set2x(PokemonType.FIGHTING, PokemonType.NORMAL, PokemonType.ICE, PokemonType.ROCK, PokemonType.DARK, PokemonType.STEEL);
        set2x(PokemonType.POISON,   PokemonType.GRASS);
        set2x(PokemonType.GROUND,   PokemonType.FIRE, PokemonType.ELECTRIC, PokemonType.POISON, PokemonType.ROCK, PokemonType.STEEL);
        set2x(PokemonType.FLYING,   PokemonType.GRASS, PokemonType.FIGHTING, PokemonType.BUG);
        set2x(PokemonType.PSYCHIC,  PokemonType.FIGHTING, PokemonType.POISON);
        set2x(PokemonType.BUG,      PokemonType.GRASS, PokemonType.PSYCHIC, PokemonType.DARK);
        set2x(PokemonType.ROCK,     PokemonType.FIRE, PokemonType.ICE, PokemonType.FLYING, PokemonType.BUG);
        set2x(PokemonType.GHOST,    PokemonType.GHOST, PokemonType.PSYCHIC);
        set2x(PokemonType.DRAGON,   PokemonType.DRAGON);
        set2x(PokemonType.DARK,     PokemonType.PSYCHIC, PokemonType.GHOST);
        set2x(PokemonType.STEEL,    PokemonType.ICE, PokemonType.ROCK);

        // 0.5x not-very-effective matchups
        setHalf(PokemonType.FIRE,     PokemonType.FIRE, PokemonType.WATER, PokemonType.ROCK, PokemonType.DRAGON);
        setHalf(PokemonType.WATER,    PokemonType.WATER, PokemonType.GRASS, PokemonType.DRAGON);
        setHalf(PokemonType.GRASS,    PokemonType.FIRE, PokemonType.GRASS, PokemonType.POISON, PokemonType.FLYING, PokemonType.BUG, PokemonType.DRAGON, PokemonType.STEEL);
        setHalf(PokemonType.ELECTRIC, PokemonType.ELECTRIC, PokemonType.GRASS, PokemonType.DRAGON);
        setHalf(PokemonType.FIGHTING, PokemonType.POISON, PokemonType.BUG, PokemonType.PSYCHIC, PokemonType.FLYING);
        setHalf(PokemonType.POISON,   PokemonType.POISON, PokemonType.GROUND, PokemonType.ROCK, PokemonType.GHOST);
        setHalf(PokemonType.GROUND,   PokemonType.GRASS, PokemonType.BUG);
        setHalf(PokemonType.FLYING,   PokemonType.ELECTRIC, PokemonType.ROCK, PokemonType.STEEL);
        setHalf(PokemonType.PSYCHIC,  PokemonType.PSYCHIC, PokemonType.STEEL);
        setHalf(PokemonType.BUG,      PokemonType.FIRE, PokemonType.FIGHTING, PokemonType.FLYING, PokemonType.GHOST, PokemonType.STEEL);
        setHalf(PokemonType.ROCK,     PokemonType.FIGHTING, PokemonType.GROUND, PokemonType.STEEL);
        setHalf(PokemonType.GHOST,    PokemonType.DARK);
        setHalf(PokemonType.DARK,     PokemonType.FIGHTING, PokemonType.DARK);
        setHalf(PokemonType.STEEL,    PokemonType.FIRE, PokemonType.WATER, PokemonType.ELECTRIC, PokemonType.STEEL);
        setHalf(PokemonType.NORMAL,   PokemonType.ROCK, PokemonType.STEEL);
        setHalf(PokemonType.ICE,      PokemonType.WATER, PokemonType.ICE);

        // 0x immune matchups
        setZero(PokemonType.NORMAL,   PokemonType.GHOST);
        setZero(PokemonType.ELECTRIC, PokemonType.GROUND);
        setZero(PokemonType.FIGHTING, PokemonType.GHOST);
        setZero(PokemonType.GROUND,   PokemonType.FLYING);
        setZero(PokemonType.PSYCHIC,  PokemonType.DARK);
        setZero(PokemonType.GHOST,    PokemonType.NORMAL);
        setZero(PokemonType.POISON,   PokemonType.STEEL);
        setZero(PokemonType.DRAGON,   PokemonType.STEEL);
    }

    private static void set2x(PokemonType attacker, PokemonType... defenders) {
        chart.computeIfAbsent(attacker, k -> new EnumMap<>(PokemonType.class));
        for (PokemonType d : defenders) chart.get(attacker).put(d, 2.0);
    }

    private static void setHalf(PokemonType attacker, PokemonType... defenders) {
        chart.computeIfAbsent(attacker, k -> new EnumMap<>(PokemonType.class));
        for (PokemonType d : defenders) chart.get(attacker).merge(d, 0.5, (old, v) -> old != 2.0 ? v : old);
    }

    private static void setZero(PokemonType attacker, PokemonType... defenders) {
        chart.computeIfAbsent(attacker, k -> new EnumMap<>(PokemonType.class));
        for (PokemonType d : defenders) chart.get(attacker).put(d, 0.0);
    }

    /** Returns the combined type multiplier for an attack hitting one or two defender types. */
    public static double getEffectiveness(PokemonType attackType, PokemonType[] defenderTypes) {
        double multiplier = 1.0;
        Map<PokemonType, Double> row = chart.getOrDefault(attackType, new EnumMap<>(PokemonType.class));
        for (PokemonType dt : defenderTypes) {
            multiplier *= row.getOrDefault(dt, 1.0);
        }
        return multiplier;
    }

    /** Returns a human-readable effectiveness label. */
    public static String effectivenessLabel(double multiplier) {
        if (multiplier == 0.0) return "It had no effect!";
        if (multiplier >= 4.0) return "It's super effective!! (4x)";
        if (multiplier >= 2.0) return "It's super effective!";
        if (multiplier <= 0.25) return "It's not very effective... (0.25x)";
        if (multiplier < 1.0)  return "It's not very effective...";
        return "";
    }

    private TypeChart() {}
}