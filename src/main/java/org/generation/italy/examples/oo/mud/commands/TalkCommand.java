package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.GameContext;
import org.generation.italy.examples.oo.mud.world.Npc;

public class TalkCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getSession().send("Parlare con chi?");
        } else {
            Entity entity = context.getCurrentRoom().findEntityByPrefix(args);
            if(entity instanceof Npc npc){
                context.getSession().send("Parli con " + npc.getName() + ": " + npc.speak());
            } else if(entity != null && entity != context.getPlayer()){
                context.getSession().send("Parli con " + entity.getName() + " (ma non risponde)");
            } else {
                context.getSession().send("Non vedo '" + args + "' qui.");
            }
        }
        return CommandOutcome.CONTINUE;
    }
}
