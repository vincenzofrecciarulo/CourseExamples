package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.GameContext;

public final class AbilityContextFactory {
    private AbilityContextFactory() {
    }

    public static AbilityContext from(GameContext context) {
        return new AbilityContext(context.getSession(), context.getPlayer(), context.getCurrentRoom(), null);
    }

    public static AbilityContext inCombat(GameContext context, Entity combatTarget) {
        return new AbilityContext(context.getSession(), context.getPlayer(), context.getCurrentRoom(), combatTarget);
    }
}
