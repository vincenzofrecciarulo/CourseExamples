package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;

public class InventoryCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        context.getSession().send("Inventario: " + context.getPlayer().getInventoryNames());
        return CommandOutcome.CONTINUE;
    }
}
