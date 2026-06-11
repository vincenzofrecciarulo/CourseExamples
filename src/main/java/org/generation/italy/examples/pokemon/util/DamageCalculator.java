package org.generation.italy.examples.pokemon.util;

import org.generation.italy.examples.pokemon.model.*;

public class DamageCalculator {

    /**
     * Official Gen-1 damage formula with STAB and type-effectiveness modifiers.
     *
     * base = ((2*level/5 + 2) * power * Atk / Def) / 50 + 2
     * final = base * STAB * effectiveness * random(0.85–1.0)
     */
    public static int calculate(Battler attacker, Battler defender, Move move) {
        if (move.getPower() == 0 || move.getCategory() == MoveCategory.STATUS) return 0;

        double atk, def;
        if (move.getCategory() == MoveCategory.PHYSICAL) {
            atk = attacker.getAttack();
            def = defender.getDefense();
            if (attacker.getStatus() == StatusEffect.BURN) atk /= 2.0;
        } else {
            atk = attacker.getSpAttack();
            def = defender.getSpDefense();
        }

        if (def <= 0) def = 1; // difesa non può essere zero: evita divisione per zero
        double baseDamage = ((2.0 * attacker.getLevel() / 5 + 2) * move.getPower() * atk / def) / 50.0 + 2;

        // STAB: +50% if move type matches one of the attacker's types
        double stab = 1.0;
        for (PokemonType t : attacker.getTypes()) {
            if (t == move.getType()) { stab = 1.5; break; }
        }

        double effectiveness = TypeChart.getEffectiveness(move.getType(), defender.getTypes());
        double random = 0.85 + Math.random() * 0.15;

        return Math.max(1, (int) (baseDamage * stab * effectiveness * random));
    }

    private DamageCalculator() {}
}