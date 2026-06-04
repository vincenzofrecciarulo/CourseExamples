package org.generation.italy.examples.oo.mud.commands;

import org.generation.italy.examples.oo.mud.world.GameContext;

public interface Command {
    /**
     * Execute this command.
     *
     * @return the outcome requested by the command
     */
    CommandOutcome execute(GameContext context, String args);
}
