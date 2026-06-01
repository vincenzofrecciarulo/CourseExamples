package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.GameContext;
import org.generation.italy.examples.oo.mud.Item;

import java.util.Optional;

public class DropCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        if(args.isEmpty()){
            context.getIo().println("Getta cosa?");
            return CommandOutcome.CONTINUE;
        }

        Optional<Item> dropped = context.getPlayer().dropByPrefix(args);
        if(dropped.isPresent()){
            context.getCurrentRoom().addItem(dropped.get());
            context.getIo().println("Hai gettato: " + dropped.get().getName());
        } else {
            context.getIo().println("Non hai questo oggetto: " + args);
        }
        return CommandOutcome.REFRESH;
    }
}
