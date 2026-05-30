package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.Entity;
import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Npc;

public class TalkCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getIo().println("Parlare con chi?");
        } else {
            Entity entity = context.getCurrentRoom().findEntityByPrefix(args);
            if(entity instanceof Npc npc){
                context.getIo().println("Parli con " + npc.getName() + ": " + npc.speak());
            } else if(entity != null && entity != context.getPlayer()){
                context.getIo().println("Parli con " + entity.getName() + " (ma non risponde)");
            } else {
                context.getIo().println("Non vedo '" + args + "' qui.");
            }
        }
        return CommandOutcome.CONTINUE;
    }
}
