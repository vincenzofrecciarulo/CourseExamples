package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.Entity;
import org.generation.italy.examples.oo.mud.GameContext;

public class AttackCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getIo().println("Attaccare chi?");
            return CommandOutcome.CONTINUE;
        }

        Entity target = context.getCurrentRoom().findEntityByPrefix(args);
        if(target == null || target == context.getPlayer()){
            context.getIo().println("Non vedo '" + args + "' qui.");
            return CommandOutcome.CONTINUE;
        }

        if(context.getCombatCoordinator() != null){
            if(context.getCombatCoordinator().isCombatActive()){
                context.getIo().println("Sei già in combattimento.");
                return CommandOutcome.CONTINUE;
            }

            if(context.getCombatCoordinator().startCombat(target)){
                context.getIo().println("Ti avventi contro " + target.getName() + ".");
            }
            return CommandOutcome.CONTINUE;
        }

        int dmg = 5;
        boolean dead = target.applyDamage(dmg);
        context.getIo().println("Hai inflitto " + dmg + " danni a " + target.getName());
        if(dead){
            context.getIo().println(target.getName() + " è morto.");
            context.getCurrentRoom().removeEntity(target);
        }
        return CommandOutcome.REFRESH;
    }
}
