package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.GameContext;

public class InventoryCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        context.getIo().println("Inventario: " + context.getPlayer().getInventoryNames());
        return CommandOutcome.CONTINUE;
    }
}
