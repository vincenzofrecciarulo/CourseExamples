package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;

public class QuitCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        context.getSession().send("Grazie per aver giocato");
        return CommandOutcome.QUIT;
    }
}
