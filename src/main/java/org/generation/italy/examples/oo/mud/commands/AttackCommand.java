package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.GameContext;

public class AttackCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if (args.isEmpty()) {
            context.getSession().send("Attaccare chi?");
            return CommandOutcome.CONTINUE;
        }

        Entity target = context.getCurrentRoom().findEntityByPrefix(args);
        if (target == null || target == context.getPlayer()) {
            context.getSession().send("Non vedo '" + args + "' qui.");
            return CommandOutcome.CONTINUE;
        }

        if (context.getCombatCoordinator().isCombatActive()) {
            context.getSession().send("Sei già in combattimento.");
            return CommandOutcome.CONTINUE;
        }

        if (context.getCombatCoordinator().startCombat(target)) {
            context.getSession().send("Ti avventi contro " + target.getName() + ".");
        }
        return CommandOutcome.CONTINUE;
    }
}
