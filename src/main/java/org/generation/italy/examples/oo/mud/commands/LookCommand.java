package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;

public class LookCommand implements Command {
    @Override
    public CommandOutcome execute(GameContext context, String args) {
        return CommandOutcome.REFRESH;
    }
}
