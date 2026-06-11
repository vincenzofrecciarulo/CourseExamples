package org.generation.italy.examples.pokemon.service;

import org.generation.italy.examples.pokemon.model.*;

public class CatchService {

    /**
     * Simplified Gen-1 catch formula.
     * a = ((3*maxHP - 2*currentHP) / (3.0*maxHP)) * catchRate * ballMultiplier
     * Catch succeeds when random(0–255) <= a.
     */
    public static boolean attemptCatch(Pokemon wild, double ballMultiplier) {
        double a = ((3.0 * wild.getMaxHp() - 2.0 * wild.getCurrentHp()) / (3.0 * wild.getMaxHp()))
                   * wild.getEntry().getCatchRate() * ballMultiplier;
        a = Math.min(255, a);

        // catchRate == 0 o HP troppo alti: cattura impossibile
        if (a <= 0) return false;

        // Three shake checks (each must succeed)
        for (int shake = 0; shake < 3; shake++) {
            int threshold = (int) (65536 / Math.pow(255.0 / a, 0.25));
            if ((int) (Math.random() * 65536) >= threshold) return false;
        }
        return true;
    }

    private CatchService() {}
}