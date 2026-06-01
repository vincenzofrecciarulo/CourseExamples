package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Item;

public class TakeCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getIo().println("Prendi cosa?");
            return CommandOutcome.CONTINUE;
        }

        Item item = context.getCurrentRoom().findItemByPrefix(args);
        if(item != null){
            context.getCurrentRoom().removeItemByName(item.getName());
            context.getPlayer().pickUp(item);
            context.getIo().println("Hai preso: " + item.getName());
        } else {
            context.getIo().println("Non c'è questo oggetto qui: " + args);
        }
        return CommandOutcome.REFRESH;
    }
}
