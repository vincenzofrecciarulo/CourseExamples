package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;
import org.generation.italy.examples.oo.mud.world.Item;

import java.util.Optional;

public class DropCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getSession().send("Getta cosa?");
            return CommandOutcome.CONTINUE;
        }

        Optional<Item> dropped = context.getPlayer().dropByPrefix(args);
        if(dropped.isPresent()){
            context.getCurrentRoom().addItem(dropped.get());
            context.getSession().send("Hai gettato: " + dropped.get().getName());
        } else {
            context.getSession().send("Non hai questo oggetto: " + args);
        }
        return CommandOutcome.REFRESH;
    }
}
