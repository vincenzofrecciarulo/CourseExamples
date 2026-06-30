package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;
import org.generation.italy.examples.oo.mud.world.Item;

public class TakeCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getSession().send("Prendi cosa?");
            return CommandOutcome.CONTINUE;
        }

        Item item = context.getCurrentRoom().findItemByPrefix(args);
        if(item != null){
            context.getCurrentRoom().removeItemByName(item.getName());
            context.getPlayer().pickUp(item);
            context.getSession().send("Hai preso: " + item.getName());
        } else {
            context.getSession().send("Non c'è questo oggetto qui: " + args);
        }
        return CommandOutcome.REFRESH;
    }
}
